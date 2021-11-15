package com.arrudamoreira.fisioneurapp.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
*
* @author marioarruda
*/
@Entity
public class Atendimento implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @JsonFormat(pattern = "dd/MM/yyyy hh:mm")
    private Date data;
    
    private String estadoPaciente;
    
    private String relatoAtendimento;
    
    @ManyToOne
    @JoinColumn(name = "prontuario_id")
    private Prontuario prontuario;
    
    @ManyToOne
    @JoinColumn(name = "fisioterapeuta_id")
    private Fisioterapeuta fisioterapeuta;

	public Atendimento() {
	}

	public Atendimento(Long id, Date data, String estadoPaciente, String relatoAtendimento) {
		this.id = id;
		this.data = data;
		this.estadoPaciente = estadoPaciente;
		this.relatoAtendimento = relatoAtendimento;
	}

	public Atendimento(Date data, String estadoPaciente, String relatoAtendimento) {
		this.data = data;
		this.estadoPaciente = estadoPaciente;
		this.relatoAtendimento = relatoAtendimento;
	}
	
	public Atendimento(Date data, String estadoPaciente, String relatoAtendimento, Prontuario prontuario, Fisioterapeuta fisioterapeuta) {
		this.data = data;
		this.estadoPaciente = estadoPaciente;
		this.relatoAtendimento = relatoAtendimento;
		this.prontuario = prontuario;
		this.fisioterapeuta = fisioterapeuta;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getEstadoPaciente() {
		return estadoPaciente;
	}

	public void setEstadoPaciente(String estadoPaciente) {
		this.estadoPaciente = estadoPaciente;
	}

	public String getRelatoAtendimento() {
		return relatoAtendimento;
	}

	public void setRelatoAtendimento(String relatoAtendimento) {
		this.relatoAtendimento = relatoAtendimento;
	}

	public Prontuario getProntuario() {
		return prontuario;
	}

	public void setProntuario(Prontuario prontuario) {
		this.prontuario = prontuario;
	}

	public Fisioterapeuta getFisioterapeuta() {
		return fisioterapeuta;
	}

	public void setFisioterapeuta(Fisioterapeuta fisioterapeuta) {
		this.fisioterapeuta = fisioterapeuta;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Atendimento other = (Atendimento) obj;
		return Objects.equals(id, other.id);
	}
}
