package com.arrudamoreira.fisioneurapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.arrudamoreira.fisioneurapp.domain.Fisioterapeuta;
import com.arrudamoreira.fisioneurapp.domain.Paciente;
import com.arrudamoreira.fisioneurapp.domain.Prontuario;
import com.arrudamoreira.fisioneurapp.dto.ProntuarioNewDTO;
import com.arrudamoreira.fisioneurapp.repositories.ProntuarioRepository;

/**
 *
 * @author Mario Arruda
 */
@Service
public class ProntuarioService {

	@Autowired
	private ProntuarioRepository repo;

	@Autowired
	private PacienteService pacienteService;

	public List<Prontuario> findAll() {
		return repo.findAll();
	}

	public Prontuario fromNewDTO(ProntuarioNewDTO objDto) {
		Paciente paciente = pacienteService.find(objDto.getPacienteId());
		return new Prontuario(null, objDto.getNumero(), objDto.getCid(), objDto.getCif(), objDto.getObservacao(),
				paciente);
	}

	@Transactional
	public Prontuario insert(Prontuario obj) {
		obj.setId(null);
		obj = repo.save(obj);
		atualizandoProntuarioPaciente(obj);
		return obj;
	}

	private void atualizandoProntuarioPaciente(Prontuario prontuario) {
		Paciente paciente = pacienteService.find(prontuario.getPaciente().getId());
		paciente.setProntuario(prontuario);
	}
	
	public Page<Prontuario> findPagePorNomePaciente(Integer page, Integer linesPerPage, String orderBy, String direction, String nomePesquisado) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		nomePesquisado = "%" + nomePesquisado + "%";
		return repo.findByPacienteNomeLike(nomePesquisado,pageRequest);
	}
}
