package com.arrudamoreira.fisioneurapp.resources;


import com.arrudamoreira.fisioneurapp.domain.EvolucaoClinica;
import com.arrudamoreira.fisioneurapp.services.EvolucaoClinicaService;
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
@RequestMapping(value = "/evolucoesClinicas")
public class EvolucaoClinicaResource {
    
    @Autowired
    private EvolucaoClinicaService service;
    
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<EvolucaoClinica>> findAll() {
        List<EvolucaoClinica> listEvolucoesClinicas = service.findAll();
        return ResponseEntity.ok(listEvolucoesClinicas);
    }
}
