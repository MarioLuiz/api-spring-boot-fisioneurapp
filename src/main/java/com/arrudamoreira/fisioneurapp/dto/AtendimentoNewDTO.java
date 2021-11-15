package com.arrudamoreira.fisioneurapp.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AtendimentoNewDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotNull
	private Long fisioterapeutaId;

	@NotNull
	private Long pacienteId;

	@NotEmpty(message = "Preenchimento Obrigatório da data")
	private String data;

	@NotEmpty(message = "Preenchimento Obrigatório da hora")
	private String hora;

	@NotEmpty(message = "Preenchimento Obrigatório do estado")
	private String estado;

	@NotEmpty(message = "Preenchimento Obrigatório do relato")
	private String relato;

	public AtendimentoNewDTO() {
	}

	public Long getFisioterapeutaId() {
		return fisioterapeutaId;
	}

	public void setFisioterapeutaId(Long fisioterapeutaId) {
		this.fisioterapeutaId = fisioterapeutaId;
	}

	public Long getPacienteId() {
		return pacienteId;
	}

	public void setPacienteId(Long pacienteId) {
		this.pacienteId = pacienteId;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getRelato() {
		return relato;
	}

	public void setRelato(String relato) {
		this.relato = relato;
	}

}
