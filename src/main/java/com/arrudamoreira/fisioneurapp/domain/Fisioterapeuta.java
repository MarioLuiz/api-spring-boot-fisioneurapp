package com.arrudamoreira.fisioneurapp.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.arrudamoreira.fisioneurapp.domain.enums.TipoPessoa;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.ManyToMany;

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

    private String especialidade;
    
    @JsonIgnore
    @ManyToMany(mappedBy = "fisioterapeutas")
    private List<Paciente> pacientes = new ArrayList<>();

    public Fisioterapeuta(Long id, String nome, String cpfOuCnpj, String email, String senha, String crefito, String especialidade) {
        this.id = id;
        this.nome = nome;
        this.cpfOuCnpj = cpfOuCnpj;
        this.email = email;
        this.senha = senha;
        this.crefito = crefito;
        this.especialidade = especialidade;
    }

    public Fisioterapeuta() {
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

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(List<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.id);
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
        final Fisioterapeuta other = (Fisioterapeuta) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Fisioterapeuta{" + "nome=" + nome + ", cpfOuCnpj=" + cpfOuCnpj + ", email=" + email + ", crefito=" + crefito + ", especialidade=" + especialidade + '}';
    }
}
