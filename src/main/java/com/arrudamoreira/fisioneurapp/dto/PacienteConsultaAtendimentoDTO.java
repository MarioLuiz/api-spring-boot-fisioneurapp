package com.arrudamoreira.fisioneurapp.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class PacienteConsultaAtendimentoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@NotNull(message = "Preenchimento Obrigatório do IdPaciente")
	private Long idPaciente;

	public Long getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(Long idPaciente) {
		this.idPaciente = idPaciente;
	}
}
