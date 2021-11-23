package com.arrudamoreira.fisioneurapp.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

public class FiltroRelatorioAtendimentoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotEmpty(message = "Preenchimento obrigatório da data inicial")
	private String atendimentoDataInicial;

	@NotEmpty(message = "Preenchimento obrigatório da data final")
	private String atendimentoDataFinal;

	private String atendminetoNomePaciente;

	private String atendimentoNomeFisioterapeuta;

	public String getAtendimentoDataInicial() {
		return atendimentoDataInicial;
	}

	public void setAtendimentoDataInicial(String atendimentoDataInicial) {
		this.atendimentoDataInicial = atendimentoDataInicial;
	}

	public String getAtendimentoDataFinal() {
		return atendimentoDataFinal;
	}

	public void setAtendimentoDataFinal(String atendimentoDataFinal) {
		this.atendimentoDataFinal = atendimentoDataFinal;
	}

	public String getAtendminetoNomePaciente() {
		return atendminetoNomePaciente;
	}

	public void setAtendminetoNomePaciente(String atendminetoNomePaciente) {
		this.atendminetoNomePaciente = atendminetoNomePaciente;
	}

	public String getAtendimentoNomeFisioterapeuta() {
		return atendimentoNomeFisioterapeuta;
	}

	public void setAtendimentoNomeFisioterapeuta(String atendimentoNomeFisioterapeuta) {
		this.atendimentoNomeFisioterapeuta = atendimentoNomeFisioterapeuta;
	}
}
