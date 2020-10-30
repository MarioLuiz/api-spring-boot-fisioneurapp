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

/**
 *
 * @author Mario Luiz
 */
@Entity
public class Avaliacao implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    
    private Date dataAvaliacao;
    
    private String dadosPessoais;
    
    private String historiaPregressa;
    
    private String historiaAtual;
    
    private String reacoesReflexos;
    
    private String desenvolvimentoMotor;
    
    private String queixaPrincipal;
    
    private String objetivoTratamento;
    
    @ManyToOne
    @JoinColumn(name = "prontuario_id")
    private Prontuario prontuario;
    
    public Avaliacao(){
    }
    
    public Avaliacao(Long Id, Date dataAvaliacao, String dadosPessoais, String historiaPregressa, String historiaAtual, String reacoesReflexos, String desenvolvimentoMotor, String queixaPrincipal, String objetivoTratamento) {
        this.Id = Id;
        this.dataAvaliacao = dataAvaliacao;
        this.dadosPessoais = dadosPessoais;
        this.historiaPregressa = historiaPregressa;
        this.historiaAtual = historiaAtual;
        this.reacoesReflexos = reacoesReflexos;
        this.desenvolvimentoMotor = desenvolvimentoMotor;
        this.queixaPrincipal = queixaPrincipal;
        this.objetivoTratamento = objetivoTratamento;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public Date getDataAvaliacao() {
        return dataAvaliacao;
    }

    public void setDataAvaliacao(Date dataAvaliacao) {
        this.dataAvaliacao = dataAvaliacao;
    }

    public String getDadosPessoais() {
        return dadosPessoais;
    }

    public void setDadosPessoais(String dadosPessoais) {
        this.dadosPessoais = dadosPessoais;
    }

    public String getHistoriaPregressa() {
        return historiaPregressa;
    }

    public void setHistoriaPregressa(String historiaPregressa) {
        this.historiaPregressa = historiaPregressa;
    }

    public String getHistoriaAtual() {
        return historiaAtual;
    }

    public void setHistoriaAtual(String historiaAtual) {
        this.historiaAtual = historiaAtual;
    }

    public String getReacoesReflexos() {
        return reacoesReflexos;
    }

    public void setReacoesReflexos(String reacoesReflexos) {
        this.reacoesReflexos = reacoesReflexos;
    }

    public String getDesenvolvimentoMotor() {
        return desenvolvimentoMotor;
    }

    public void setDesenvolvimentoMotor(String desenvolvimentoMotor) {
        this.desenvolvimentoMotor = desenvolvimentoMotor;
    }

    public String getQueixaPrincipal() {
        return queixaPrincipal;
    }

    public void setQueixaPrincipal(String queixaPrincipal) {
        this.queixaPrincipal = queixaPrincipal;
    }

    public String getObjetivoTratamento() {
        return objetivoTratamento;
    }

    public void setObjetivoTratamento(String objetivoTratamento) {
        this.objetivoTratamento = objetivoTratamento;
    }

    public Prontuario getProntuario() {
        return prontuario;
    }

    public void setProntuario(Prontuario prontuario) {
        this.prontuario = prontuario;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.Id);
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
        final Avaliacao other = (Avaliacao) obj;
        if (!Objects.equals(this.Id, other.Id)) {
            return false;
        }
        return true;
    }
}
