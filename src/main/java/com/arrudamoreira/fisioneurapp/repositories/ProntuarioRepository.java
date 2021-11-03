package com.arrudamoreira.fisioneurapp.repositories;

import com.arrudamoreira.fisioneurapp.domain.Prontuario;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Mario Arruda
 */
@Repository
public interface ProntuarioRepository extends JpaRepository<Prontuario, Integer> {
	
	@Query("SELECT p FROM Prontuario p "
			+ "JOIN p.paciente pa "
			+ "WHERE pa.nome like :nome")
	Page<Prontuario>findByPacienteNomeLike(String nome, Pageable pageable);
}
