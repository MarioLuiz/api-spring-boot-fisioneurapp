package com.arrudamoreira.fisioneurapp.repositories;

import com.arrudamoreira.fisioneurapp.domain.Prontuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Mario Arruda
 */
@Repository
public interface ProntuarioRepository extends JpaRepository<Prontuario, Integer> {

}
