package com.arrudamoreira.fisioneurapp.resources;


import com.arrudamoreira.fisioneurapp.domain.Paciente;
import com.arrudamoreira.fisioneurapp.services.PacienteService;
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
@RequestMapping(value = "/pacientes")
public class PacienteResource {
    
    @Autowired
    private PacienteService service;
    
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Paciente>> findAll() {
        List<Paciente> listPacientes = service.findAll();
        return ResponseEntity.ok(listPacientes);
    }
}
