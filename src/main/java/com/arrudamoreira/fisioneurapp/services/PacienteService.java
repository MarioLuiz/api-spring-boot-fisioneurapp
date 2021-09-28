package com.arrudamoreira.fisioneurapp.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.arrudamoreira.fisioneurapp.domain.Fisioterapeuta;
import com.arrudamoreira.fisioneurapp.domain.Paciente;
import com.arrudamoreira.fisioneurapp.dto.PacienteNewDTO;
import com.arrudamoreira.fisioneurapp.repositories.PacienteRepository;

/**
 *
 * @author Mario Arruda
 */
@Service
public class PacienteService {

	@Autowired
	private PacienteRepository repo;

	@Autowired
	private FisioterapeutaService fisioterapeutaService;

	public List<Paciente> findAll() {
		return repo.findAll();
	}

	@Transactional
	public Paciente insert(Paciente obj) {
		obj.setId(null);
		obj = repo.save(obj);
		return obj;
	}

	public Paciente fromDTO(PacienteNewDTO objDto) {

		Paciente paciente = new Paciente(null, new Date(), objDto.getCpf(), objDto.getTelefone(), objDto.getNome(),
				objDto.getDataNascimento(), objDto.getEmail());

		atualizandoPacienteFisioterapeuta(objDto.getFisioterapeutaId(), paciente);

		return paciente;
	}

	private void atualizandoPacienteFisioterapeuta(Long fisioterapeutaId, Paciente paciente) {
		Fisioterapeuta fisio = fisioterapeutaService.find(fisioterapeutaId);
		paciente.getFisioterapeutas().add(fisio);
	}

	public Page<Paciente> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}

}
