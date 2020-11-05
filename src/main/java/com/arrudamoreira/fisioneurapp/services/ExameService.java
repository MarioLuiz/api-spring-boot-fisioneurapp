package com.arrudamoreira.fisioneurapp.services;


import com.arrudamoreira.fisioneurapp.domain.Exame;
import com.arrudamoreira.fisioneurapp.repositories.ExameRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Mario Arruda
 */
@Service
public class ExameService {
    
    @Autowired
    private ExameRepository repo;
    
    public List<Exame> findAll() {
        return repo.findAll();
    }
    
}
