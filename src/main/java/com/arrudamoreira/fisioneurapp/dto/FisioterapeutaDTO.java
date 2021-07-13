package com.arrudamoreira.fisioneurapp.dto;

import java.io.Serializable;
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
    private String Nome;

    @NotEmpty(message = "Preenchimento Obrigatório")
    @Length(min = 5, max = 120, message = "O tamanho deve ser entre 5 e 120 caracteres")
    private String cpfOuCnpj;

    @NotEmpty(message = "Preenchimento Obrigatório")
    @Length(min = 5, max = 120, message = "O tamanho deve ser entre 5 e 120 caracteres")
    private String email;

    @NotEmpty(message = "Preenchimento Obrigatório")
    @Length(min = 8, max = 120, message = "O tamanho deve ser entre 5 e 120 caracteres")
    private String senha;

    private String crefito;
    @NotEmpty(message = "Preenchimento Obrigatório")
    @Length(min = 5, max = 120, message = "O tamanho deve ser entre 5 e 120 caracteres")

    public FisioterapeutaDTO() {

    }

    public FisioterapeutaDTO(Long id, String Nome, String cpfOuCnpj, String email, String senha, String crefito, String especialidade) {
        this.id = id;
        this.Nome = Nome;
        this.cpfOuCnpj = cpfOuCnpj;
        this.email = email;
        this.senha = senha;
        this.crefito = crefito;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
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

}
