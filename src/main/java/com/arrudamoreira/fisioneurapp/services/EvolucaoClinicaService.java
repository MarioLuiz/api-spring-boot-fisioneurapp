package com.arrudamoreira.fisioneurapp.services;


import com.arrudamoreira.fisioneurapp.domain.EvolucaoClinica;
import com.arrudamoreira.fisioneurapp.repositories.EvolucaoClinicaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Mario Arruda
 */
@Service
public class EvolucaoClinicaService {
    
    @Autowired
    private EvolucaoClinicaRepository repo;
    
    public List<EvolucaoClinica> findAll() {
        return repo.findAll();
    }
    
}
