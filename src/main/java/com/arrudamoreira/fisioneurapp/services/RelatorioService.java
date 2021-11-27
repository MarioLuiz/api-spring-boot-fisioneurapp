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
import com.arrudamoreira.fisioneurapp.domain.Paciente;
import com.arrudamoreira.fisioneurapp.dto.FiltroRelatorioAtendimentoDTO;
import com.arrudamoreira.fisioneurapp.dto.FiltroRelatorioPacienteDTO;
import com.arrudamoreira.fisioneurapp.repositories.AtendimentoRepository;
import com.arrudamoreira.fisioneurapp.repositories.PacienteRepository;
import com.arrudamoreira.fisioneurapp.services.exceptions.CustomValidationException;

/**
 *
 * @author Mario Arruda
 */
@Service
public class RelatorioService {

	@Autowired
	private AtendimentoRepository atendimentoRepository;

	@Autowired
	private PacienteRepository pacienteRepository;

	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS"); // dd/MM/yyyy HH:mm:ss.SSS

	public Page<Atendimento> relatorioAtendimentos(FiltroRelatorioAtendimentoDTO obj, Integer page,
			Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);

		obj.setAtendminetoNomePaciente(colocaPorcentagem(obj.getAtendminetoNomePaciente()));
		obj.setAtendimentoNomeFisioterapeuta(colocaPorcentagem(obj.getAtendimentoNomeFisioterapeuta()));

		Date dataInicial = null;
		Date dataFinal = null;
		try {
			dataInicial = sdf.parse(obj.getAtendimentoDataInicial() + " 00:00:00.000");
			dataFinal = sdf.parse(obj.getAtendimentoDataFinal() + " 23:59:59.999");
			validaDatas(dataInicial, dataFinal);
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

	public Page<Paciente> relatorioPacientes(FiltroRelatorioPacienteDTO obj, Integer page, Integer linesPerPage,
			String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);

		obj.setPacienteNome(colocaPorcentagem(obj.getPacienteNome()));
//		obj.setPacienteCid(colocaPorcentagem(obj.getPacienteCid()));
//		obj.setPacienteCif(colocaPorcentagem(obj.getPacienteCif()));

		Date dataNascimentoInicial = null;
		Date dataNascimentoFinal = null;
		if (haCamposData(obj.getPacienteDataNascimentoInicial(), obj.getPacienteDataNascimentoFinal())) {
			try {
				dataNascimentoInicial = sdf.parse(obj.getPacienteDataNascimentoInicial() + " 00:00:00.000");
				dataNascimentoFinal = sdf.parse(obj.getPacienteDataNascimentoFinal() + " 23:59:59.999");
				validaDatas(dataNascimentoInicial, dataNascimentoFinal);
			} catch (ParseException e) {
				e.printStackTrace();
				throw new CustomValidationException("Erro ao converter datas: " + obj.getPacienteDataNascimentoInicial()
						+ " " + obj.getPacienteDataNascimentoFinal() + " " + " Erro: "
						+ RelatorioService.class.getName(), e);
			}
		} else {
			try {
				dataNascimentoInicial = sdf.parse("1500-01-01 00:00:00.000");
			} catch (ParseException e) {
				throw new CustomValidationException("Erro ao converter data inicial 1500-01-01 00:00:00.000 :", e);
			}
			dataNascimentoFinal = new Date();
		}

		Date dataCadastroInicial = null;
		Date dataCadastrotoFinal = null;
		if (haCamposData(obj.getPacienteDataCadastroInicial(), obj.getPacienteDataCadastroFinal())) {
			try {
				dataCadastroInicial = sdf.parse(obj.getPacienteDataCadastroInicial() + " 00:00:00.000");
				dataCadastrotoFinal = sdf.parse(obj.getPacienteDataCadastroFinal() + " 23:59:59.999");
				validaDatas(dataCadastroInicial, dataCadastrotoFinal);
			} catch (ParseException e) {
				e.printStackTrace();
				throw new CustomValidationException("Erro ao converter datas: " + obj.getPacienteDataNascimentoInicial()
						+ " " + obj.getPacienteDataNascimentoFinal() + " " + obj.getPacienteDataCadastroInicial() + " "
						+ obj.getPacienteDataCadastroFinal() + " Erro: " + RelatorioService.class.getName(), e);
			}
		} else {
			try {
				dataCadastroInicial = sdf.parse("1500-01-01 00:00:00.000");
			} catch (ParseException e) {
				throw new CustomValidationException("Erro ao converter data inicial 1500-01-01 00:00:00.000 :", e);
			}
			dataCadastrotoFinal = new Date();
		}

		Page<Paciente> listaPacientePaginada = pacienteRepository.findRelatorioPorDatasNomePaciente(
				dataNascimentoInicial, dataNascimentoFinal, obj.getPacienteNome(), dataCadastroInicial,
				dataCadastrotoFinal, pageRequest); //, obj.getPacienteCid(), obj.getPacienteCif()
		return listaPacientePaginada;
	}

	public String colocaPorcentagem(String semPorcentagem) {
		return ("%" + semPorcentagem + "%");
	}

	public void validaDatas(Date dataIncial, Date dataFinal) {
		if (dataIncial.after(dataFinal)) {
			throw new CustomValidationException("Data inicial deve ser antes da data final e vice e versa!");
		}
	}

	public boolean haCamposData(String dataIncial, String dataFinal) {
		boolean flag = false;
		if (dataIncial.isBlank() && dataFinal.isBlank()) {
			return flag;
		}

		if (dataIncial.isBlank() && !dataFinal.isBlank()) {
			throw new CustomValidationException("Data inicial e final dos campos deve ser preenchida");
		}

		if (!dataIncial.isBlank() && dataFinal.isBlank()) {
			throw new CustomValidationException("Data inicial e final dos campos deve ser preenchida");
		}

		if (!dataIncial.isBlank() && !dataFinal.isBlank()) {
			flag = true;
		}
		return flag;
	}

}
