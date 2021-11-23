package com.arrudamoreira.fisioneurapp.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.arrudamoreira.fisioneurapp.domain.Atendimento;
import com.arrudamoreira.fisioneurapp.dto.FiltroRelatorioAtendimentoDTO;
import com.arrudamoreira.fisioneurapp.repositories.AtendimentoRepository;
import com.arrudamoreira.fisioneurapp.services.exceptions.CustomValidationException;

/**
 *
 * @author Mario Arruda
 */
@Service
public class RelatorioService {

	@Autowired
	private AtendimentoRepository atendimentoRepository;

	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS"); // dd/MM/yyyy HH:mm:ss.SSS

	public Page<Atendimento> relatorioAtendimentos(FiltroRelatorioAtendimentoDTO obj, Integer page,
			Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);

		obj.setAtendminetoNomePaciente("%" + obj.getAtendminetoNomePaciente() + "%");
		obj.setAtendimentoNomeFisioterapeuta("%" + obj.getAtendimentoNomeFisioterapeuta() + "%");

		Date dataInicial = null;
		Date dataFinal = null;
		try {
			dataInicial = sdf.parse(obj.getAtendimentoDataInicial() + " 00:00:00.000");
			dataFinal = sdf.parse(obj.getAtendimentoDataFinal() + " 23:59:59.999");
		} catch (ParseException e) {
			e.printStackTrace();
			throw new CustomValidationException(
					"Erro ao converter dataInicial e dataFinal: " + RelatorioService.class.getName() + " ", e);
		}

		Page<Atendimento> listaAtendimentoPaginada = atendimentoRepository
				.findRelatorioPorDatasNomePacienteNomeFiosioterapeuta(dataInicial, dataFinal,
						obj.getAtendminetoNomePaciente(), obj.getAtendimentoNomeFisioterapeuta(), pageRequest);
		return listaAtendimentoPaginada;
	}

}
