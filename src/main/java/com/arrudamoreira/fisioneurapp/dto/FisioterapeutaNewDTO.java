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
    
    @NotEmpty(message = "Preenchimento Obrigatório")
    @Length(min = 5, max = 120, message = "O tamanho do nome deve ser entre 5 a 120 caracteres")
    private String nome;
    
    @NotEmpty(message = "Preenchimento Obrigatório")
    private String cpfOuCnpj;
    
    @NotEmpty(message = "Preenchimento Obrigatório")
    private String email;
    
    @NotEmpty(message = "Preenchimento Obrigatório")
    private String senha;
    
    @NotEmpty(message = "Preenchimento Obrigatório")
    private String crefito;
    
    @NotEmpty(message = "Preenchimento Obrigatório")
    private String especialidade;
    
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

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
}
