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

import com.arrudamoreira.fisioneurapp.domain.Atendimento;
import com.arrudamoreira.fisioneurapp.domain.Prontuario;
import com.arrudamoreira.fisioneurapp.dto.AtendimentoNewDTO;
import com.arrudamoreira.fisioneurapp.dto.ProntuarioNewDTO;
import com.arrudamoreira.fisioneurapp.services.AtendimentoService;

/**
*
* @author Mario Arruda
*/
@RestController
@RequestMapping(value = "/atendimentos")
public class AtendimentoResourse {
	
	@Autowired
    private AtendimentoService service;
    
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Atendimento>> findAll() {
        List<Atendimento> listAtendimento = service.findAll();
        return ResponseEntity.ok(listAtendimento);
    }
    
    @RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody AtendimentoNewDTO objDto) {
		Atendimento atendimento = service.fromNewDTO(objDto);
		atendimento = service.insert(atendimento);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(atendimento.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}
    
    @RequestMapping(value = "/page", method = RequestMethod.GET)
	public ResponseEntity<Page<Atendimento>> findPage(
			@RequestParam(value="page", defaultValue = "0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue = "24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue = "id") String orderBy,
			@RequestParam(value="direction", defaultValue = "ASC") String direction,
			@RequestParam(value="nome", defaultValue = "") String nome) {
		Page<Atendimento> listAtendimentos = service.findPagePorNomePaciente(page, linesPerPage, orderBy, direction, nome);
		return ResponseEntity.ok(listAtendimentos);
	}

}
