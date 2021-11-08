package com.arrudamoreira.fisioneurapp.resources;


import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.arrudamoreira.fisioneurapp.domain.Prontuario;
import com.arrudamoreira.fisioneurapp.dto.ProntuarioNewDTO;
import com.arrudamoreira.fisioneurapp.dto.ProntuarioUpdateDTO;
import com.arrudamoreira.fisioneurapp.services.ProntuarioService;

/**
 *
 * @author Mario Arruda
 */
@RestController
@RequestMapping(value = "/prontuarios")
public class ProntuarioResource {
    
    @Autowired
    private ProntuarioService service;
    
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Prontuario>> findAll() {
        List<Prontuario> listProntuarios = service.findAll();
        return ResponseEntity.ok(listProntuarios);
    }
    
    @RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody ProntuarioNewDTO objDto) {
		Prontuario prontuario = service.fromNewDTO(objDto);
		prontuario = service.insert(prontuario);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(prontuario.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}
    
    @RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody ProntuarioUpdateDTO objDto) {
		Prontuario prontuario = service.fromUpdateDTO(objDto);
		prontuario = service.update(prontuario);
		return ResponseEntity.noContent().build();
	}
    
    @RequestMapping(value = "/page", method = RequestMethod.GET)
	public ResponseEntity<Page<Prontuario>> findPage(
			@RequestParam(value="page", defaultValue = "0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue = "24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue = "id") String orderBy,
			@RequestParam(value="direction", defaultValue = "ASC") String direction,
			@RequestParam(value="nome", defaultValue = "") String nome) {
		Page<Prontuario> listProntuarios = service.findPagePorNomePaciente(page, linesPerPage, orderBy, direction, nome);
		return ResponseEntity.ok(listProntuarios);
	}
}
