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
 * @author marruda
 */
@Entity
public class Encaminhamento implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String especialidade;
    
    @JsonFormat(pattern = "dd/MM/yyyy hh:mm")
    private Date data;
    
    private String relatorio; 
    
    @ManyToOne
    @JoinColumn(name = "prontuario_id")
    private Prontuario prontuario;
    
    public Encaminhamento(){
    }

    public Encaminhamento(Long id, String especialidade, Date data, String relatorio) {
        this.id = id;
        this.especialidade = especialidade;
        this.data = data;
        this.relatorio = relatorio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getRelatorio() {
        return relatorio;
    }

    public void setRelatorio(String relatorio) {
        this.relatorio = relatorio;
    }

    public Prontuario getProntuario() {
        return prontuario;
    }

    public void setProntuario(Prontuario prontuario) {
        this.prontuario = prontuario;
    }
}
