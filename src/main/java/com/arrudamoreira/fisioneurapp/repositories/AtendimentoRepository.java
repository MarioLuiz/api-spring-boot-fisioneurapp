package com.arrudamoreira.fisioneurapp.repositories;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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
			+ "WHERE UPPER(pa.nome) like UPPER(:nome)")
	Page<Atendimento>findByPacienteNomeLike(String nome, Pageable pageable);
	
	@Query("SELECT a FROM Atendimento a "
			+ "JOIN a.prontuario p "
			+ "JOIN p.paciente pa "
			+ "WHERE pa.id = :idPaciente")
	Page<Atendimento>findRelatorioPorIdPaciente(Long idPaciente, Pageable pageable);
	
	@Query("SELECT a FROM Atendimento a "
			+ "JOIN a.prontuario p "
			+ "JOIN a.fisioterapeuta f "
			+ "JOIN p.paciente pa "
			+ "WHERE UPPER(pa.nome) like UPPER(:nomePaciente) AND "
			+ "UPPER(f.nome) like UPPER(:nomeFisioterapeuta) AND "
	        + "(a.data BETWEEN :dataInicial AND :dataFinal)")
	Page<Atendimento>findRelatorioPorDatasNomePacienteNomeFiosioterapeuta(@Param("dataInicial") Date dataInicial, 
			@Param("dataFinal") Date dataFinal, @Param("nomePaciente") String nomePaciente, @Param("nomeFisioterapeuta") String nomeFisioterapeuta, Pageable pageable);
	
	@Query(value ="SELECT * FROM ATENDIMENTO A "
			+ "INNER JOIN FISIOTERAPEUTA F "
			+ "ON A.FISIOTERAPEUTA_ID = F.id "
			+ "INNER JOIN PRONTUARIO P "
			+ "ON A.PRONTUARIO_ID = P.id "
			+ "INNER JOIN PACIENTE PA "
			+ "ON P.id = PA.PRONTUARIO_ID "
			+ "WHERE UPPER(PA.NOME) LIKE UPPER(:nomePaciente) AND "
			+ "UPPER(F.NOME) LIKE UPPER(:nomeFisioterapeuta) AND "
			+ "(A.DATA BETWEEN :dataInicial AND :dataFinal)", nativeQuery = true)
	Page<Atendimento>findRelatorioPorDatasNomePacienteNomeFiosioterapeutaNativo(@Param("dataInicial") Date dataInicial, 
			@Param("dataFinal") Date dataFinal,@Param("nomePaciente") String nomePaciente, @Param("nomeFisioterapeuta") String nomeFisioterapeuta, Pageable pageable);
}
