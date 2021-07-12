package com.arrudamoreira.fisioneurapp.services;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.arrudamoreira.fisioneurapp.domain.Fisioterapeuta;
import com.arrudamoreira.fisioneurapp.repositories.FisioterapeutaRepository;
import com.arrudamoreira.fisioneurapp.services.exceptions.ObjectNotFoundException;

@Service
public class AuthService {
	
	@Autowired
	private FisioterapeutaRepository fisioterapeutaRepository;
	
	@Autowired
	private BCryptPasswordEncoder pe;
	
	@Autowired
	private EmailService emailService;

	private Random rand = new Random();
	
	public void sendNewPassword(String email) {
		
		Fisioterapeuta fisio = fisioterapeutaRepository.findByEmail(email);
		
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

}
