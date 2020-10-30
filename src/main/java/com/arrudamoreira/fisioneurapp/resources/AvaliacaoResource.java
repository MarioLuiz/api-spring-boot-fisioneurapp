package com.arrudamoreira.fisioneurapp.resources;


import com.arrudamoreira.fisioneurapp.domain.Avaliacao;
import com.arrudamoreira.fisioneurapp.services.AvaliacaoService;
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
@RequestMapping(value = "/avaliacoes")
public class AvaliacaoResource {
    
    @Autowired
    private AvaliacaoService service;
    
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Avaliacao>> findAll() {
        List<Avaliacao> listAvaliacoes = service.findAll();
        return ResponseEntity.ok(listAvaliacoes);
    }
}
