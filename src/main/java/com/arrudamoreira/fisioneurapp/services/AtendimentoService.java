package com.arrudamoreira.fisioneurapp.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.arrudamoreira.fisioneurapp.domain.Atendimento;
import com.arrudamoreira.fisioneurapp.domain.Fisioterapeuta;
import com.arrudamoreira.fisioneurapp.domain.Prontuario;
import com.arrudamoreira.fisioneurapp.dto.AtendimentoNewDTO;
import com.arrudamoreira.fisioneurapp.dto.AtendimentoUpdateDTO;
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
	
	public Atendimento update(Atendimento obj) {
		Atendimento newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	private void updateData(Atendimento newObj, Atendimento obj) {
		newObj.setProntuario(obj.getProntuario());
		newObj.setData(obj.getData());
		newObj.setEstadoPaciente(obj.getEstadoPaciente());
		newObj.setRelatoAtendimento(obj.getRelatoAtendimento());
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
	
	public Atendimento fromUpdateDTO(AtendimentoUpdateDTO objDto) {
		Date data = null;
		try {
			data = sdf.parse(objDto.getData()+" "+objDto.getHora());
		} catch (ParseException e) {
			e.printStackTrace();
			throw new CustomValidationException("Erro ao converter data e hora: " + AtendimentoService.class.getName() + " ", e);
		}
		
		Prontuario prontuario = pacienteService.find(objDto.getPacienteId()).getProntuario();
		Fisioterapeuta fisio = fisioterapeutaService.find(objDto.getFisioterapeutaId());

		Atendimento atendimento = new Atendimento(objDto.getId(),data, objDto.getEstado(), objDto.getRelato(), prontuario, fisio);
		
		return atendimento;
	}
	
	public Page<Atendimento> findPagePorNomePaciente(Integer page, Integer linesPerPage, String orderBy, String direction, String nomePesquisado) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		nomePesquisado = "%" + nomePesquisado + "%";
		return repo.findByPacienteNomeLike(nomePesquisado,pageRequest);
	}
}
