package com.arrudamoreira.fisioneurapp.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Mario Arruda
 */
@Entity
public class Paciente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "PACIENTE_FISIOTERAPEUTA", joinColumns = @JoinColumn(name = "paciente_id"), inverseJoinColumns = @JoinColumn(name = "fisioterapeuta_id"))
	private List<Fisioterapeuta> fisioterapeutas = new ArrayList<>();

	@JsonFormat(pattern = "dd/MM/yyyy hh:mm")
	private Date dataCadastro;

	private String cpf;

	private String telefone;

	private String nome;
	
	@JsonFormat(pattern = "dd/MM/yyyy hh:mm")
	private Date dataNascimento;

	private String email;
	
	private Boolean podeVisualizarSeuAtendimento;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "endereco_id", referencedColumnName = "id")
	private Endereco endereco;
	
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "prontuario_id", referencedColumnName = "id")
	private Prontuario prontuario;

	public Paciente() {
	}

	public Paciente(Long id, Date dataCadastro, String cpf, String telefone, String nome, String dataNascimento,
			String email, Boolean podeVisualizarSeuAtendimento) {
		this.id = id;
		this.dataCadastro = dataCadastro;
		this.cpf = cpf;
		this.telefone = telefone;
		this.nome = nome;
		this.dataNascimento = dataConvert(dataNascimento);
		this.email = email;
		this.podeVisualizarSeuAtendimento = podeVisualizarSeuAtendimento;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Fisioterapeuta> getFisioterapeutas() {
		return fisioterapeutas;
	}

	public void setFisioterapeutas(List<Fisioterapeuta> fisioterapeutas) {
		this.fisioterapeutas = fisioterapeutas;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Prontuario getProntuario() {
		return prontuario;
	}

	public void setProntuario(Prontuario prontuario) {
		this.prontuario = prontuario;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getPodeVisualizarSeuAtendimento() {
		return podeVisualizarSeuAtendimento;
	}

	public void setPodeVisualizarSeuAtendimento(Boolean podeVisualizarSeuAtendimento) {
		this.podeVisualizarSeuAtendimento = podeVisualizarSeuAtendimento;
	}

	private Date dataConvert(String dataString) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date dataFormatada = null;
		try {
			dataFormatada = sdf.parse(dataString);
		} catch (ParseException e) {
			e.printStackTrace();
			System.out.println("Erro ao converter data: " + e);
		}
		return dataFormatada;
	}

	@Override
	public int hashCode() {
		int hash = 7;
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
		final Paciente other = (Paciente) obj;
		if (!Objects.equals(this.id, other.id)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Paciente{" + "fisioterapeutas=" + fisioterapeutas + ", dataCadastro=" + dataCadastro + ", cpf=" + cpf
				+ ", telefone=" + telefone + ", nome=" + nome + ", endereco=" + endereco + ", prontuario="
				+ prontuario + '}';
	}
}
