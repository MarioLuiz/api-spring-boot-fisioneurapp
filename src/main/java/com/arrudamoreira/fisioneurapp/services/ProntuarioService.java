package com.arrudamoreira.fisioneurapp.services;


import com.arrudamoreira.fisioneurapp.domain.Prontuario;
import com.arrudamoreira.fisioneurapp.repositories.ProntuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Mario Arruda
 */
@Service
public class ProntuarioService {
    
    @Autowired
    private ProntuarioRepository repo;
    
    public List<Prontuario> findAll() {
        return repo.findAll();
    }
    
}
