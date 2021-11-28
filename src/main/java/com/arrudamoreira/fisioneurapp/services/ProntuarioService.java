package com.arrudamoreira.fisioneurapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.arrudamoreira.fisioneurapp.domain.Paciente;
import com.arrudamoreira.fisioneurapp.domain.Prontuario;
import com.arrudamoreira.fisioneurapp.dto.ProntuarioNewDTO;
import com.arrudamoreira.fisioneurapp.dto.ProntuarioUpdateDTO;
import com.arrudamoreira.fisioneurapp.repositories.ProntuarioRepository;
import com.arrudamoreira.fisioneurapp.services.exceptions.ObjectNotFoundException;

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
	
	public Optional<Prontuario> findByNumero(Integer prontuario) {
		return repo.findByNumero(prontuario);
	}
	
	public Prontuario find(Long id) {
		Optional<Prontuario> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Prontuario.class.getName()));
	}

	public Prontuario fromNewDTO(ProntuarioNewDTO objDto) {
		Paciente paciente = pacienteService.find(objDto.getPacienteId());
		return new Prontuario(null, objDto.getNumero(), objDto.getCid(), objDto.getCif(), objDto.getObservacao(),
				paciente);
	}
	
	public Prontuario fromUpdateDTO(ProntuarioUpdateDTO objDto) {
		return new Prontuario(objDto.getId(), objDto.getCid(), objDto.getCif(), objDto.getObservacao());
	}

	@Transactional
	public Prontuario insert(Prontuario obj) {
		obj.setId(null);
		obj = repo.save(obj);
		atualizandoProntuarioPaciente(obj);
		return obj;
	}
	
	public Prontuario update(Prontuario obj) {
		Prontuario newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	private void updateData(Prontuario newObj, Prontuario obj) {
		newObj.setCid(obj.getCid());
		newObj.setCif(obj.getCif());
		newObj.setObservacao(obj.getObservacao());
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
