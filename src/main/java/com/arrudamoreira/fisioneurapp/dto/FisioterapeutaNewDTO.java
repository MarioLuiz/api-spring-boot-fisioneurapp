package com.arrudamoreira.fisioneurapp.dto;

import java.io.Serializable;
import javax.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author marioarruda
 */
public class FisioterapeutaNewDTO implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @NotEmpty(message = "Preenchimento Obrigatório do nome")
    @Length(min = 2, max = 120, message = "O tamanho do nome deve ser entre 5 a 120 caracteres")
    private String nome;
    
    @NotEmpty(message = "Preenchimento Obrigatório do cpfOuCnpj")
    private String cpfOuCnpj;
    
    @NotEmpty(message = "Preenchimento Obrigatório do email")
    private String email;
    
    @NotEmpty(message = "Preenchimento Obrigatório da senha")
    private String senha;
    
    @NotEmpty(message = "Preenchimento Obrigatório do crefito")
    private String crefito;
    
    @NotEmpty(message = "Preenchimento Obrigatório da data")
    private String dataNascimento;
    
    public FisioterapeutaNewDTO(){
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

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
}
