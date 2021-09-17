package com.arrudamoreira.fisioneurapp.resources;


import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.arrudamoreira.fisioneurapp.domain.Fisioterapeuta;
import com.arrudamoreira.fisioneurapp.dto.FisioterapeutaDTO;
import com.arrudamoreira.fisioneurapp.dto.FisioterapeutaNewDTO;
import com.arrudamoreira.fisioneurapp.dto.FisioterapeutaUpdateDTO;
import com.arrudamoreira.fisioneurapp.services.FisioterapeutaService;

/**
 *
 * @author Mario Arruda
 */
@RestController
@RequestMapping(value = "/fisioterapeutas")
public class FisioterapeutaResource {
    
    @Autowired
    private FisioterapeutaService service;
    
    // Apenas Users com role Admin podem acessar esse recurso
    @PreAuthorize("hasAnyRole('ADMIN')")
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Fisioterapeuta>> findAll() {
        List<Fisioterapeuta> listFisiotetapeutas = service.findAll();
        return ResponseEntity.ok(listFisiotetapeutas);
    }
    
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseEntity<Fisioterapeuta> find(@PathVariable Long id) {
        Fisioterapeuta fisio = service.find(id);
        return ResponseEntity.ok(fisio);
    }
    
    @RequestMapping(value = "/email/{email}",method = RequestMethod.GET)
    public ResponseEntity<Fisioterapeuta> find(@PathVariable String email) {
        Fisioterapeuta fisio = service.findByEmail(email);
        return ResponseEntity.ok(fisio);
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@Valid @RequestBody FisioterapeutaNewDTO objDto) {
        Fisioterapeuta fisio = service.fromDTO(objDto);
        fisio = service.insert(fisio);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(fisio.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
    
    // Apenas Users com role Admin podem acessar esse recurso
    @PreAuthorize("hasAnyRole('ADMIN')")
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@Valid @RequestBody FisioterapeutaDTO objDto, @PathVariable Long id) {
        Fisioterapeuta fisio = service.fromDTO(objDto);
        fisio.setId(id);
        fisio = service.update(fisio);
        return ResponseEntity.noContent().build();
    }
    
    @RequestMapping(value = "cadastro/{id}",method = RequestMethod.PUT)
    public ResponseEntity<Void> updateCadastro(@Valid @RequestBody FisioterapeutaUpdateDTO objDto, @PathVariable Long id) {
    	Fisioterapeuta fisio = service.fromUpdateDTO(objDto);
        fisio.setId(id);
        fisio = service.update(fisio);
        return ResponseEntity.noContent().build();
    }
    
    @RequestMapping(value = "senha/{id}",method = RequestMethod.PUT)
    public ResponseEntity<Void> updatePass(@Valid @RequestBody FisioterapeutaDTO objDto, @PathVariable Long id) {
        Fisioterapeuta fisio = service.fromDTO(objDto);
        fisio.setId(id);
        fisio = service.update(fisio);
        return ResponseEntity.noContent().build();
    }
}
