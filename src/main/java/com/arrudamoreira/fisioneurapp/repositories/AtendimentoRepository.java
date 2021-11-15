package com.arrudamoreira.fisioneurapp.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.arrudamoreira.fisioneurapp.domain.Atendimento;

/**
*
* @author Mario Arruda
*/
@Repository
public interface AtendimentoRepository extends JpaRepository<Atendimento, Long>{
	
	@Query("SELECT a FROM Atendimento a "
			+ "JOIN a.prontuario p "
			+ "JOIN p.paciente pa "
			+ "WHERE pa.nome like :nome")
	Page<Atendimento>findByPacienteNomeLike(String nome, Pageable pageable);
}
