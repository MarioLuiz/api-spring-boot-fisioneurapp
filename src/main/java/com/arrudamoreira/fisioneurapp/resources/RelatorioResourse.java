package com.arrudamoreira.fisioneurapp.resources;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.arrudamoreira.fisioneurapp.domain.Atendimento;
import com.arrudamoreira.fisioneurapp.dto.FiltroRelatorioAtendimentoDTO;
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
	public ResponseEntity<Page<Atendimento>> relatorioAtendimentos(@Valid @RequestBody FiltroRelatorioAtendimentoDTO objDto,
			@RequestParam(value="page", defaultValue = "0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue = "10000") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue = "id") String orderBy,
			@RequestParam(value="direction", defaultValue = "ASC") String direction) {
		Page<Atendimento> listAtendimentos = service.relatorioAtendimentos(objDto, page, linesPerPage, orderBy, direction);
		return ResponseEntity.ok(listAtendimentos);
	}
}
