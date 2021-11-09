package com.arrudamoreira.fisioneurapp.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author Mario Luiz
 */
@Entity
public class Prontuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Integer numero;

	private String cid;

	private String cif;

	private Date dataCriacao;

	private String observacao;

	@OneToOne(mappedBy = "prontuario")
	private Paciente paciente;
	
	@JsonIgnore
	@OneToMany(mappedBy = "prontuario")
	private List<Atendimento> atendimentos = new ArrayList<>();

	@JsonIgnore
	@OneToMany(mappedBy = "prontuario")
	private List<Avaliacao> avaliacoes = new ArrayList<>();

	@JsonIgnore
	@OneToMany(mappedBy = "prontuario")
	private List<EvolucaoClinica> evolucoesClinicas = new ArrayList<>();

	@JsonIgnore
	@OneToMany(mappedBy = "prontuario")
	private List<Exame> exames = new ArrayList<>();

	@JsonIgnore
	@OneToMany(mappedBy = "prontuario")
	private List<Encaminhamento> encaminhamentos = new ArrayList<>();

	public Prontuario() {
	}

	public Prontuario(Long id, Integer numero, String cid, Date dataCriacao, String observacao) {
		this.id = id;
		this.numero = numero;
		this.cid = cid;
		this.dataCriacao = dataCriacao;
		this.observacao = observacao;
	}

	public Prontuario(Long id, Integer numero, String cid, String cif, String observacao, Paciente paciente) {
		this.id = id;
		this.numero = numero;
		this.cid = cid;
		this.cif = cif;
		this.dataCriacao = new Date();
		this.observacao = observacao;
		this.paciente = paciente;
	}

	public Prontuario(Long id, String cid, String cif, String observacao) {
		this.id = id;
		this.cid = cid;
		this.cif = cif;
		this.observacao = observacao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public List<Atendimento> getAtendimentos() {
		return atendimentos;
	}

	public void setAtendimentos(List<Atendimento> atendimentos) {
		this.atendimentos = atendimentos;
	}

	public List<Avaliacao> getAvaliacoes() {
		return avaliacoes;
	}

	public void setAvaliacoes(List<Avaliacao> avaliacoes) {
		this.avaliacoes = avaliacoes;
	}

	public List<EvolucaoClinica> getEvolucoesClinicas() {
		return evolucoesClinicas;
	}

	public void setEvolucoesClinicas(List<EvolucaoClinica> evolucoesClinicas) {
		this.evolucoesClinicas = evolucoesClinicas;
	}

	public List<Exame> getExames() {
		return exames;
	}

	public void setExames(List<Exame> exames) {
		this.exames = exames;
	}

	public List<Encaminhamento> getEncaminhamentos() {
		return encaminhamentos;
	}

	public void setEncaminhamentos(List<Encaminhamento> encaminhamentos) {
		this.encaminhamentos = encaminhamentos;
	}

	@Override
	public int hashCode() {
		int hash = 3;
		hash = 23 * hash + Objects.hashCode(this.id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Prontuario other = (Prontuario) obj;
		if (!Objects.equals(this.id, other.id)) {
			return false;
		}
		return true;
	}
}
