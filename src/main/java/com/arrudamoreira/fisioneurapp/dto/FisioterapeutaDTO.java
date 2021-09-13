package com.arrudamoreira.fisioneurapp.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author marioarruda
 */
public class FisioterapeutaDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    @NotEmpty(message = "Preenchimento Obrigatório")
    @Length(min = 5, max = 120, message = "O tamanho deve ser entre 5 e 120 caracteres")
    private String nome;

    @NotEmpty(message = "Preenchimento Obrigatório do cpfOuCnpj")
    @Length(min = 5, max = 120, message = "O tamanho deve ser entre 5 e 120 caracteres")
    private String cpfOuCnpj;

    @NotEmpty(message = "Preenchimento Obrigatório do email")
    @Length(min = 5, max = 120, message = "O tamanho deve ser entre 5 e 120 caracteres")
    private String email;

    @NotEmpty(message = "Preenchimento Obrigatório da senha")
    @Length(min = 8, max = 120, message = "O tamanho deve ser entre 5 e 120 caracteres")
    private String senha;

    private String crefito;
    @NotEmpty(message = "Preenchimento Obrigatório do crefito")
    @Length(min = 5, max = 120, message = "O tamanho deve ser entre 5 e 120 caracteres")
    
    @NotEmpty(message = "Preenchimento Obrigatório da dataNascimento")
    private Long dataNascimento;

    public FisioterapeutaDTO() {

    }

    public FisioterapeutaDTO(Long id, String nome, String cpfOuCnpj, String email, String senha, String crefito, Long dataNascimento) {
        this.id = id;
        this.nome = nome;
        this.cpfOuCnpj = cpfOuCnpj;
        this.email = email;
        this.senha = senha;
        this.crefito = crefito;
        this.dataNascimento = dataNascimento;
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

	public Long getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Long dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
}
