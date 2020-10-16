package com.arrudamoreira.fisioneuapp.repositories;

import com.arrudamoreira.fisioneuapp.domain.Fisioterapeuta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Mario Arruda
 */
@Repository
public interface FisioterapeutaRepository extends JpaRepository<Fisioterapeuta, Integer> {

}
