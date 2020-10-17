package com.arrudamoreira.fisioneuapp.resources;

import com.arrudamoreira.fisioneuapp.domain.Fisioterapeuta;
import com.arrudamoreira.fisioneuapp.service.FisioterapeutaService;
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
@RequestMapping(value = "/fisioterapeutas")
public class FisioterapeutaResource {
    
    @Autowired
    private FisioterapeutaService service;
    
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Fisioterapeuta>> findAll() {
        List<Fisioterapeuta> listFisiotetapeutas = service.findAll();
        return ResponseEntity.ok(listFisiotetapeutas);
    }
}
