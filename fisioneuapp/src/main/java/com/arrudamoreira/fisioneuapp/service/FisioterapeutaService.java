/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arrudamoreira.fisioneuapp.service;

import com.arrudamoreira.fisioneuapp.domain.Fisioterapeuta;
import com.arrudamoreira.fisioneuapp.repositories.FisioterapeutaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Mario Arruda
 */
@Service
public class FisioterapeutaService {
    
    @Autowired
    private FisioterapeutaRepository repo;
    
    public List<Fisioterapeuta> findAll() {
        return repo.findAll();
    }
    
}
