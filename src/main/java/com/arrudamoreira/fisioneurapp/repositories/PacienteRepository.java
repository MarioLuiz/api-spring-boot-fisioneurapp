package com.arrudamoreira.fisioneurapp.repositories;

import java.util.Date;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.arrudamoreira.fisioneurapp.domain.Paciente;

/**
 *
 * @author Mario Arruda
 */
@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {

	Page<Paciente> findByNomeLikeIgnoreCase(String nome, Pageable pageable);

	Page<Paciente> findByNomeLikeIgnoreCaseAndProntuarioIsNull(String nome, Pageable pageable);

	Page<Paciente> findByNomeLikeIgnoreCaseAndProntuarioIsNotNull(String nome, Pageable pageable);

	Optional<Paciente> findById(Long id);
	
	Optional<Paciente> findByCpf(String cpf);

	@Query("SELECT p FROM Paciente p " 
			+ "WHERE  UPPER(p.nome) like  UPPER(:nomePaciente) AND "
			+ "p.cpf like :cpfPaciente AND "
			+ "(p.dataNascimento BETWEEN :dataNascimentoInicial AND :dataNascimentoFinal) AND "
			+ "(p.dataCadastro BETWEEN :dataCadastroInicial AND :dataCadastroFinal)")
	Page<Paciente> findRelatorioPorDatasNomePaciente(@Param("dataNascimentoInicial") Date dataNascimentoInicial,
			@Param("dataNascimentoFinal") Date dataNascimentoFinal, @Param("nomePaciente") String nomePaciente,
			@Param("dataCadastroInicial") Date dataCadastroInicial, @Param("dataCadastroFinal") Date dataCadastroFinal,
			@Param("cpfPaciente") String cpfPaciente,Pageable pageable);

	
//	  @Query( "SELECT p FROM Paciente p " 
//			  + "LEFT JOIN p.prontuario pro " 
//			  + "WHERE p.nome like :nomePaciente AND " 
//			  + "(p.dataNascimento BETWEEN :dataNascimentoInicial AND :dataNascimentoFinal) AND "
//			  + "(p.dataCadastro BETWEEN :dataCadastroInicial AND :dataCadastroFinal) AND "
//			  + "pro.cid like :cid AND " 
//			  + "pro.cif like :cif") Page<Paciente>
//	  findRelatorioPorDatasNomePacienteCidCif(
//	  @Param("dataNascimentoInicial") Date dataNascimentoInicial,
//	  @Param("dataNascimentoFinal") Date dataNascimentoFinal,
//	  @Param("nomePaciente") String nomePaciente,
//	  @Param("dataCadastroInicial") Date dataCadastroInicial,
//	  @Param("dataCadastroFinal") Date dataCadastroFinal,
//	  @Param("cid") String cid,
//	  @Param("cif") String cif, Pageable pageable);
	 
}
