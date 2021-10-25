package com.arrudamoreira.fisioneurapp.repositories;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arrudamoreira.fisioneurapp.domain.Paciente;

/**
 *
 * @author Mario Arruda
 */
@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Integer> {
	
	Page<Paciente> findByNomeLike(String nome, Pageable pageable);

	Optional<Paciente> findById(Long id);
}
