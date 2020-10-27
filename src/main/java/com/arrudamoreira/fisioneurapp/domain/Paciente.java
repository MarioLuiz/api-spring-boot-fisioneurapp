package com.arrudamoreira.fisioneurapp.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
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

/**
 *
 * @author Mario Arruda
 */
@Entity
public class Paciente implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "PACIENTE_FISIOTERAPEUTA",
            joinColumns = @JoinColumn(name = "paciente_id"),
            inverseJoinColumns = @JoinColumn(name = "fisioterapeuta_id")
    )
    private List<Fisioterapeuta> fisioterapeutas = new ArrayList<>();

    @JsonFormat(pattern = "dd/MM/yyyy hh:mm")
    private Date dataCadastro;

    private String cpf;

    private String telefone;

    private String nome;
    
    @OneToMany(mappedBy = "paciente", cascade=CascadeType.ALL)
    private List<Endereco> enderecos = new ArrayList<>();

    public Paciente() {
    }

    public Paciente(Integer id, Date dataCadastro, String cpf, String telefone, String nome) {
        this.id = id;
        this.dataCadastro = dataCadastro;
        this.cpf = cpf;
        this.telefone = telefone;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
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
}
