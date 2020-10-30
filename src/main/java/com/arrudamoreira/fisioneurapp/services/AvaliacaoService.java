package com.arrudamoreira.fisioneurapp.services;


import com.arrudamoreira.fisioneurapp.domain.Avaliacao;
import com.arrudamoreira.fisioneurapp.repositories.AvaliacaoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Mario Arruda
 */
@Service
public class AvaliacaoService {
    
    @Autowired
    private AvaliacaoRepository repo;
    
    public List<Avaliacao> findAll() {
        return repo.findAll();
    }
    
}
