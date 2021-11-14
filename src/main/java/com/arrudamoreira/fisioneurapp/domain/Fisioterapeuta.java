package com.arrudamoreira.fisioneurapp.domain;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.arrudamoreira.fisioneurapp.domain.enums.Perfil;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author Mario Arruda
 */
@Entity
public class Fisioterapeuta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;

	private String cpfOuCnpj;

	private String email;

	@JsonIgnore
	private String senha;

	private String crefito;

	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "PERFIS")
	private Set<Integer> perfis = new HashSet<>();

	@JsonIgnore
	@ManyToMany(mappedBy = "fisioterapeutas")
	private List<Paciente> pacientes = new ArrayList<>();
	
	private Date dataNascimento;
	
	@JsonIgnore
	@OneToMany(mappedBy = "fisioterapeuta")
	private List<Atendimento> atendimentos = new ArrayList<>();

	public Fisioterapeuta() {
		addPerfil(Perfil.CLIENTE_FISIO);
	}

	public Fisioterapeuta(Long id, String nome, String cpfOuCnpj, String email, String senha, String crefito, String dataNascimento) {
		this.id = id;
		this.nome = nome;
		this.cpfOuCnpj = cpfOuCnpj;
		this.email = email;
		this.senha = senha;
		this.crefito = crefito;
		this.dataNascimento = dataConvert(dataNascimento);
		addPerfil(Perfil.CLIENTE_FISIO);
	}
	
	public Fisioterapeuta(Long id, String nome, String cpfOuCnpj, String email, String senha, String crefito, Date dataNascimento) {
		this.id = id;
		this.nome = nome;
		this.cpfOuCnpj = cpfOuCnpj;
		this.email = email;
		this.senha = senha;
		this.crefito = crefito;
		this.dataNascimento = dataNascimento;
		addPerfil(Perfil.CLIENTE_FISIO);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpfOuCnpj() {
		return cpfOuCnpj;
	}

	public void setCpfOuCnpj(String cpfOuCnpj) {
		this.cpfOuCnpj = cpfOuCnpj;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCrefito() {
		return crefito;
	}

	public void setCrefito(String crefito) {
		this.crefito = crefito;
	}

	public Set<Perfil> getPerfis() {
		return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
	}

	public void addPerfil(Perfil perfil) {
		perfis.add(perfil.getCod());
	}

	public List<Paciente> getPacientes() {
		return pacientes;
	}

	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}
	
	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public List<Atendimento> getAtendimentos() {
		return atendimentos;
	}

	public void setAtendimentos(List<Atendimento> atendimentos) {
		this.atendimentos = atendimentos;
	}

	private Date dataConvert(String dataString) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date dataFormatado = null;
		try {
			dataFormatado = sdf.parse(dataString);
		} catch (ParseException e) {
			e.printStackTrace();
			System.out.println("Erro ao converter data: "+ e);
		}
		return dataFormatado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fisioterapeuta other = (Fisioterapeuta) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
