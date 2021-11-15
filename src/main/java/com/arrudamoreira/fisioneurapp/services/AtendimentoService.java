package com.arrudamoreira.fisioneurapp.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.arrudamoreira.fisioneurapp.domain.Atendimento;
import com.arrudamoreira.fisioneurapp.domain.Fisioterapeuta;
import com.arrudamoreira.fisioneurapp.domain.Prontuario;
import com.arrudamoreira.fisioneurapp.dto.AtendimentoNewDTO;
import com.arrudamoreira.fisioneurapp.repositories.AtendimentoRepository;
import com.arrudamoreira.fisioneurapp.services.exceptions.CustomValidationException;
import com.arrudamoreira.fisioneurapp.services.exceptions.ObjectNotFoundException;

@Service
public class AtendimentoService {

	@Autowired
	private AtendimentoRepository repo;
	
	@Autowired
	private PacienteService pacienteService;
	
	@Autowired
	private FisioterapeutaService fisioterapeutaService;

	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

	public List<Atendimento> findAll() {
		return repo.findAll();
	}

	public Optional<Atendimento> findById(Long id) {
		return repo.findById(id);
	}

	public Atendimento find(Long id) {
		Optional<Atendimento> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Atendimento.class.getName()));
	}

	@Transactional
	public Atendimento insert(Atendimento obj) {
		obj.setId(null);
		obj = repo.save(obj);
		return obj;
	}

	public Atendimento fromNewDTO(AtendimentoNewDTO objDto) {
		Date data = null;
		try {
			data = sdf.parse(objDto.getData()+" "+objDto.getHora());
		} catch (ParseException e) {
			e.printStackTrace();
			throw new CustomValidationException("Erro ao converter data e hora: " + Atendimento.class.getName() + " ", e);
		}
		
		Prontuario prontuario = pacienteService.find(objDto.getPacienteId()).getProntuario();
		Fisioterapeuta fisio = fisioterapeutaService.find(objDto.getFisioterapeutaId());

		Atendimento atendimento = new Atendimento(data, objDto.getEstado(), objDto.getRelato(), prontuario, fisio);

		return atendimento;
	}
}
