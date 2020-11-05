package com.arrudamoreira.fisioneurapp.resources;


import com.arrudamoreira.fisioneurapp.domain.Exame;
import com.arrudamoreira.fisioneurapp.services.ExameService;
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
@RequestMapping(value = "/exames")
public class ExameResource {
    
    @Autowired
    private ExameService service;
    
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Exame>> findAll() {
        List<Exame> listExames = service.findAll();
        return ResponseEntity.ok(listExames);
    }
}
