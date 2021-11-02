package com.arrudamoreira.fisioneurapp.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class ProntuarioNewDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long pacienteId;
	
	@NotNull
	private Integer numero;

    private String cid;
    
    private String cif;

    private String observacao;
    
    public ProntuarioNewDTO() {
    }
    
	public Long getPacienteId() {
		return pacienteId;
	}

	public void setPacienteId(Long pacienteId) {
		this.pacienteId = pacienteId;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getCif() {
		return cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
}
