package com.arrudamoreira.fisioneurapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arrudamoreira.fisioneurapp.domain.Atendimento;
import com.arrudamoreira.fisioneurapp.repositories.AtendimentoRepository;

@Service
public class AtendimentoService {
	
	@Autowired
    private AtendimentoRepository repo;
    
    public List<Atendimento> findAll() {
        return repo.findAll();
    }
}
