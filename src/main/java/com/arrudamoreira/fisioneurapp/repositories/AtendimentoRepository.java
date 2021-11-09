package com.arrudamoreira.fisioneurapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arrudamoreira.fisioneurapp.domain.Atendimento;

/**
*
* @author Mario Arruda
*/
@Repository
public interface AtendimentoRepository extends JpaRepository<Atendimento, Long>{

}
