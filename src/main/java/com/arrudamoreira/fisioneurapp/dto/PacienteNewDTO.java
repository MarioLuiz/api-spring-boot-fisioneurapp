package com.arrudamoreira.fisioneurapp.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

public class PacienteNewDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long fisioterapeutaId;

	@NotEmpty(message = "Preenchimento Obrigatório do nome")
	@Length(min = 2, max = 120, message = "O tamanho do nome deve ser entre 2 a 120 caracteres")
	private String nome;

	private String email;
	
	@NotEmpty(message = "Preenchimento obrigatório do telefone")
	private String telefone;

	@Length(min = 11, max = 11, message = "O tamanho do cpf deve ser 11 caracteres")
	private String cpf;

	@NotEmpty(message = "Preenchimento Obrigatório da data")
	private String dataNascimento;

	public PacienteNewDTO() {
	}

	public Long getFisioterapeutaId() {
		return fisioterapeutaId;
	}

	public void setFisioterapeutaId(Long fisioterapeutaId) {
		this.fisioterapeutaId = fisioterapeutaId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
}
