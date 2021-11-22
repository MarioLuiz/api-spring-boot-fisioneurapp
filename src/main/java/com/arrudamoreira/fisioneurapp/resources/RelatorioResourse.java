package com.arrudamoreira.fisioneurapp.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.arrudamoreira.fisioneurapp.domain.Atendimento;
import com.arrudamoreira.fisioneurapp.services.RelatorioService;

/**
 *
 * @author Mario Arruda
 */
@RestController
@RequestMapping(value = "/relatorios")
public class RelatorioResourse {

	@Autowired
	private RelatorioService service;
	
	
	@RequestMapping(value = "/atendimentos", method = RequestMethod.GET)
	public ResponseEntity<List<Atendimento>> relatorioAtendimentos(
			@RequestParam(value="atendimentoDataInicial", defaultValue = "") String dataInicial, 
			@RequestParam(value="atendimentoDataFinal", defaultValue = "") String dataFinal, 
			@RequestParam(value="atendminetoNomePaciente", defaultValue = "") String nomePaciente,
			@RequestParam(value="atendimentoNomeFisioterapeuta", defaultValue = "") String nomeFisioterapeuta) {
		List<Atendimento> listAtendimentos = service.relatorioAtendimentos(dataInicial, dataFinal, nomePaciente, nomeFisioterapeuta);
		return ResponseEntity.ok(listAtendimentos);
	}
}
