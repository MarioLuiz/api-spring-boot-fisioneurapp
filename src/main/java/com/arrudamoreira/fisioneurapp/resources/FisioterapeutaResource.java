package com.arrudamoreira.fisioneurapp.resources;


import com.arrudamoreira.fisioneurapp.domain.Fisioterapeuta;
import com.arrudamoreira.fisioneurapp.dto.FisioterapeutaNewDTO;
import com.arrudamoreira.fisioneurapp.services.FisioterapeutaService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
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
    
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@Valid @RequestBody FisioterapeutaNewDTO objDto) {
        
        return null;
    }
}
