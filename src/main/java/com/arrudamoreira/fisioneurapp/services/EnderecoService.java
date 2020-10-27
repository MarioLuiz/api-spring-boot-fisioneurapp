package com.arrudamoreira.fisioneurapp.services;


import com.arrudamoreira.fisioneurapp.domain.Endereco;
import com.arrudamoreira.fisioneurapp.repositories.EnderecoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Mario Arruda
 */
@Service
public class EnderecoService {
    
    @Autowired
    private EnderecoRepository repo;
    
    public List<Endereco> findAll() {
        return repo.findAll();
    }
    
}
