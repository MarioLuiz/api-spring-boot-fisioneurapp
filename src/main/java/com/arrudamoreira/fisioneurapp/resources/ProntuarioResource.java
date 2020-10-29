package com.arrudamoreira.fisioneurapp.resources;


import com.arrudamoreira.fisioneurapp.domain.Prontuario;
import com.arrudamoreira.fisioneurapp.services.ProntuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
}
