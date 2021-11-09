package com.arrudamoreira.fisioneurapp.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.arrudamoreira.fisioneurapp.domain.Atendimento;
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

}
