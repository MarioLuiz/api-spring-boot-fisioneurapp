package com.arrudamoreira.fisioneurapp.dto;

import java.io.Serializable;

public class FiltroRelatorioPacienteDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String pacienteDataNascimentoInicial;

	private String pacienteDataNascimentoFinal;
		
	private String pacienteDataCadastroInicial;

	private String pacienteDataCadastroFinal;

	private String pacienteNome;
	
	private String pacienteCid;
	
	private String pacienteCif;

	public String getPacienteDataNascimentoInicial() {
		return pacienteDataNascimentoInicial;
	}

	public void setPacienteDataNascimentoInicial(String pacienteDataNascimentoInicial) {
		this.pacienteDataNascimentoInicial = pacienteDataNascimentoInicial;
	}

	public String getPacienteDataNascimentoFinal() {
		return pacienteDataNascimentoFinal;
	}

	public void setPacienteDataNascimentoFinal(String pacienteDataNascimentoFinal) {
		this.pacienteDataNascimentoFinal = pacienteDataNascimentoFinal;
	}

	public String getPacienteDataCadastroInicial() {
		return pacienteDataCadastroInicial;
	}

	public void setPacienteDataCadastroInicial(String pacienteDataCadastroInicial) {
		this.pacienteDataCadastroInicial = pacienteDataCadastroInicial;
	}

	public String getPacienteDataCadastroFinal() {
		return pacienteDataCadastroFinal;
	}

	public void setPacienteDataCadastroFinal(String pacienteDataCadastroFinal) {
		this.pacienteDataCadastroFinal = pacienteDataCadastroFinal;
	}

	public String getPacienteNome() {
		return pacienteNome;
	}

	public void setPacienteNome(String pacienteNome) {
		this.pacienteNome = pacienteNome;
	}

	public String getPacienteCid() {
		return pacienteCid;
	}

	public void setPacienteCid(String pacienteCid) {
		this.pacienteCid = pacienteCid;
	}

	public String getPacienteCif() {
		return pacienteCif;
	}

	public void setPacienteCif(String pacienteCif) {
		this.pacienteCif = pacienteCif;
	}
}
