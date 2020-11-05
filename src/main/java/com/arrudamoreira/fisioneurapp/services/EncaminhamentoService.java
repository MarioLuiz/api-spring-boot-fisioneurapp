package com.arrudamoreira.fisioneurapp.services;

import com.arrudamoreira.fisioneurapp.domain.Encaminhamento;
import com.arrudamoreira.fisioneurapp.repositories.EncaminhamentoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Mario Arruda
 */
@Service
public class EncaminhamentoService {
    
    @Autowired
    private EncaminhamentoRepository repo;
    
    public List<Encaminhamento> findAll() {
        return repo.findAll();
    }
    
}
