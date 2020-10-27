package com.arrudamoreira.fisioneurapp.repositories;

import com.arrudamoreira.fisioneurapp.domain.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Mario Arruda
 */
@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {

}
