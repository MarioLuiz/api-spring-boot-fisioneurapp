package com.arrudamoreira.fisioneurapp.resources;


import com.arrudamoreira.fisioneurapp.domain.Paciente;
import com.arrudamoreira.fisioneurapp.domain.Prontuario;
import com.arrudamoreira.fisioneurapp.dto.PacienteNewDTO;
import com.arrudamoreira.fisioneurapp.dto.ProntuarioNewDTO;
import com.arrudamoreira.fisioneurapp.services.ProntuarioService;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
}
