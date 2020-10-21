package com.arrudamoreira.fisioneurapp.services;


import com.arrudamoreira.fisioneurapp.domain.Paciente;
import com.arrudamoreira.fisioneurapp.repositories.PacienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Mario Arruda
 */
@Service
public class PacienteService {
    
    @Autowired
    private PacienteRepository repo;
    
    public List<Paciente> findAll() {
        return repo.findAll();
    }
    
}
