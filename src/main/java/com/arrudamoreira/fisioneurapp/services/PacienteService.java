package com.arrudamoreira.fisioneurapp.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.arrudamoreira.fisioneurapp.domain.Fisioterapeuta;
import com.arrudamoreira.fisioneurapp.domain.Paciente;
import com.arrudamoreira.fisioneurapp.dto.PacienteNewDTO;
import com.arrudamoreira.fisioneurapp.dto.PacienteUpdateDTO;
import com.arrudamoreira.fisioneurapp.repositories.PacienteRepository;
import com.arrudamoreira.fisioneurapp.services.exceptions.DataIntegrityException;
import com.arrudamoreira.fisioneurapp.services.exceptions.ObjectNotFoundException;

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
	
	public Optional<Paciente> findById(Long id) {
		return repo.findById(id);
	}
	
	public Paciente find(Long id) {
		Optional<Paciente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Paciente.class.getName()));
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
	
	public Paciente fromUpdateDTO(PacienteUpdateDTO objDto) {
		
		Paciente paciente = new Paciente(objDto.getId(), new Date(), objDto.getCpf(), objDto.getTelefone(), objDto.getNome(),
				objDto.getDataNascimento(), objDto.getEmail());

		atualizandoPacienteFisioterapeuta(objDto.getFisioterapeutaId(), paciente);

		return paciente;
	}
	
	public Paciente update(Paciente obj) {
		Paciente newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	private void updateData(Paciente newObj, Paciente obj) {
		newObj.setNome(obj.getNome());
		newObj.setEmail(obj.getEmail());
		newObj.setTelefone(obj.getTelefone());
		newObj.setCpf(obj.getCpf());
		newObj.setDataNascimento(obj.getDataNascimento());
	}
	
	public void delete(Long id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (Exception e) {
			throw new DataIntegrityException("Não é possivel excluir porque há prontuários relacionados. Erro: "+ e);
		}
	}

	private void atualizandoPacienteFisioterapeuta(Long fisioterapeutaId, Paciente paciente) {
		Fisioterapeuta fisio = fisioterapeutaService.find(fisioterapeutaId);
		paciente.getFisioterapeutas().add(fisio);
	}

	public Page<Paciente> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	public Page<Paciente> findPageCustom(Integer page, Integer linesPerPage, String orderBy, String direction, String nomePesquisado) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		nomePesquisado = "%" + nomePesquisado + "%";
		return repo.findByNomeLike(nomePesquisado,pageRequest);
	}
	
	public Page<Paciente> findPagePacientesSemProntuario(Integer page, Integer linesPerPage, String orderBy, String direction, String nomePesquisado) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		nomePesquisado = "%" + nomePesquisado + "%";
		return repo.findByNomeLikeAndProntuarioIsNull(nomePesquisado,pageRequest);
	}

}
