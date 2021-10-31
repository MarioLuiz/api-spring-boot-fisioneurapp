package com.arrudamoreira.fisioneurapp.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.arrudamoreira.fisioneurapp.domain.Paciente;
import com.arrudamoreira.fisioneurapp.dto.PacienteNewDTO;
import com.arrudamoreira.fisioneurapp.dto.PacienteUpdateDTO;
import com.arrudamoreira.fisioneurapp.services.PacienteService;

/**
 *
 * @author Mario Arruda
 */
@RestController
@RequestMapping(value = "/pacientes")
public class PacienteResource {

	@Autowired
	private PacienteService service;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Paciente>> findAll() {
		List<Paciente> listPacientes = service.findAll();
		return ResponseEntity.ok(listPacientes);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody PacienteNewDTO objDto) {
		Paciente paciente = service.fromDTO(objDto);
		paciente = service.insert(paciente);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(paciente.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody PacienteUpdateDTO objDto) {
		Paciente paciente = service.fromUpdateDTO(objDto);
		paciente = service.update(paciente);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value= "/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ResponseEntity<Page<Paciente>> findPage(
			@RequestParam(value="page", defaultValue = "0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue = "24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue = "nome") String orderBy,
			@RequestParam(value="direction", defaultValue = "ASC") String direction) {
		Page<Paciente> listPacientes = service.findPage(page, linesPerPage, orderBy, direction);
		return ResponseEntity.ok(listPacientes);
	}
	
	@RequestMapping(value = "/page/custom", method = RequestMethod.GET)
	public ResponseEntity<Page<Paciente>> findPageCustom(
			@RequestParam(value="page", defaultValue = "0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue = "24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue = "nome") String orderBy,
			@RequestParam(value="direction", defaultValue = "ASC") String direction,
			@RequestParam(value="nome", defaultValue = "") String nome) {
		Page<Paciente> listPacientes = service.findPageCustom(page, linesPerPage, orderBy, direction, nome);
		return ResponseEntity.ok(listPacientes);
	}
	
	@RequestMapping(value = "/page/semProntuario", method = RequestMethod.GET)
	public ResponseEntity<Page<Paciente>> findPageSemProntuario(
			@RequestParam(value="page", defaultValue = "0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue = "24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue = "nome") String orderBy,
			@RequestParam(value="direction", defaultValue = "ASC") String direction,
			@RequestParam(value="nome", defaultValue = "") String nome) {
		Page<Paciente> listPacientes = service.findPagePacientesSemProntuario(page, linesPerPage, orderBy, direction, nome);
		return ResponseEntity.ok(listPacientes);
	}
}
