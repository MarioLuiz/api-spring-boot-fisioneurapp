package com.arrudamoreira.fisioneurapp.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    private Date dataCriacao;

    private String resumo;

    @JsonIgnore
    @OneToOne(mappedBy = "prontuario")
    private Paciente paciente;

    @JsonIgnore
    @OneToMany(mappedBy = "prontuario")
    private List<Avaliacao> avaliacoes = new ArrayList<>();
    
    @JsonIgnore
    @OneToMany(mappedBy = "prontuario")
    private List<EvolucaoClinica> evolucoesClinicas = new ArrayList<>();

    public Prontuario() {
    }

    public Prontuario(Long id, Integer numero, String cid, Date dataCriacao, String resumo) {
        this.id = id;
        this.numero = numero;
        this.cid = cid;
        this.dataCriacao = dataCriacao;
        this.resumo = resumo;
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

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
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
