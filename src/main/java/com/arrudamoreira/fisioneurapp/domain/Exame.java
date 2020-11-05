package com.arrudamoreira.fisioneurapp.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author marioarruda
 */
@Entity
public class Exame implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nome;
    
    @JsonFormat(pattern = "dd/MM/yyyy hh:mm")
    private Date data;
    
    private String observacao;
    
    private String parecerProfissional;
    
    @ManyToOne
    @JoinColumn(name = "prontuario_id")
    private Prontuario prontuario;
    
    public Exame(){
    }

    public Exame(Long id, String nome, Date data, String observacao, String parecerProfissional) {
        this.id = id;
        this.nome = nome;
        this.data = data;
        this.observacao = observacao;
        this.parecerProfissional = parecerProfissional;
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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getParecerProfissional() {
        return parecerProfissional;
    }

    public void setParecerProfissional(String parecerProfissional) {
        this.parecerProfissional = parecerProfissional;
    }

    public Prontuario getProntuario() {
        return prontuario;
    }

    public void setProntuario(Prontuario prontuario) {
        this.prontuario = prontuario;
    }  
}
