package com.arrudamoreira.fisioneurapp.repositories;

import com.arrudamoreira.fisioneurapp.domain.Fisioterapeuta;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Mario Arruda
 */
@Repository
public interface FisioterapeutaRepository extends JpaRepository<Fisioterapeuta, Integer> {
    
    @Transactional(readOnly = true)
    Fisioterapeuta findByEmail(String email);

    public Optional<Fisioterapeuta> findById(Long id);

}
