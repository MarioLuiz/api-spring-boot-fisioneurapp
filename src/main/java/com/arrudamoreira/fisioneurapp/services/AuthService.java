package com.arrudamoreira.fisioneurapp.services;

import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.arrudamoreira.fisioneurapp.domain.Fisioterapeuta;
import com.arrudamoreira.fisioneurapp.domain.Paciente;
import com.arrudamoreira.fisioneurapp.domain.Prontuario;
import com.arrudamoreira.fisioneurapp.dto.PacienteLoginDTO;
import com.arrudamoreira.fisioneurapp.repositories.FisioterapeutaRepository;
import com.arrudamoreira.fisioneurapp.services.exceptions.ObjectNotFoundException;

@Service
public class AuthService {
	
	@Autowired
	private FisioterapeutaRepository fisioterapeutaRepository;
	
	@Autowired
	private PacienteService pacienteService;
	
	@Autowired
	private ProntuarioService prontuarioService;
	
	@Autowired
	private BCryptPasswordEncoder pe;
	
	@Autowired
	private EmailService emailService;

	private Random rand = new Random();
	
	public void sendNewPassword(String email) {
		
		Fisioterapeuta fisio = fisioterapeutaRepository.findByEmailIgnoreCase(email);
		
		if (fisio == null) {
			throw new ObjectNotFoundException("Email não encontrado");
		}
		
		String newPass = newPassword();
		
		fisio.setSenha(pe.encode(newPass));
		
		fisioterapeutaRepository.save(fisio);
		
		emailService.sendNewPasswordEmail(fisio, newPass);
	}
	
	private String newPassword() {

		char[] vet = new char[10];
		for (int i = 0; i < vet.length; i++) {
			vet[i] = randomchar();
		}
		return new String(vet);
	}

	private char randomchar() {
		int opt = rand.nextInt(3);
		if (opt == 0) { // gera um digito de 0 a 9
			return (char) (rand.nextInt(10) + 48);
		} else if (opt == 1) { // gera uma letra maiuscula de A a Z
			return (char) (rand.nextInt(26) + 65);
		} else { // gera uma letra minuscula de A a Z
			return (char) (rand.nextInt(26) + 97);
		}
	}
	
	public void autenticaPaciente(PacienteLoginDTO obj) {
		Optional<Paciente> paciente = pacienteService.findByCpf(obj.getCpf());
		paciente.orElseThrow(() -> new ObjectNotFoundException(
				"Paciente não encontrado! cpf ou prontuario!"));
		
		Optional<Prontuario> prontuario = prontuarioService.findByNumero(obj.getNumeroProntuario());
		prontuario.orElseThrow(() -> new ObjectNotFoundException(
				"Paciente não encontrado! prontuario ou cpf!"));
		
		if(!prontuario.get().getPaciente().getCpf().equalsIgnoreCase(obj.getCpf()) ) {
			throw new ObjectNotFoundException(
				"Cpf ou Numero de prontuário não correspondem a base!");
		}
		
		if(!prontuario.get().getPaciente().getPodeVisualizarSeuAtendimento()) {
			throw new ObjectNotFoundException(
					"Paciente não liberado para consultar atendimentos!");
		}
	}

}
