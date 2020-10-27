package com.arrudamoreira.fisioneurapp.resources;


import com.arrudamoreira.fisioneurapp.domain.Endereco;
import com.arrudamoreira.fisioneurapp.services.EnderecoService;
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
@RequestMapping(value = "/enderecos")
public class EnderecoResource {
    
    @Autowired
    private EnderecoService service;
    
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Endereco>> findAll() {
        List<Endereco> listEnderecos = service.findAll();
        return ResponseEntity.ok(listEnderecos);
    }
}
