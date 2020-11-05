package com.arrudamoreira.fisioneurapp.resources;


import com.arrudamoreira.fisioneurapp.domain.Encaminhamento;
import com.arrudamoreira.fisioneurapp.services.EncaminhamentoService;
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
@RequestMapping(value = "/encaminhamentos")
public class EncaminhamentoResource {
    
    @Autowired
    private EncaminhamentoService service;
    
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Encaminhamento>> findAll() {
        List<Encaminhamento> listEncaminhamentos = service.findAll();
        return ResponseEntity.ok(listEncaminhamentos);
    }
}
