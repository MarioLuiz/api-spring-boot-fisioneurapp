package com.arrudamoreira.fisioneuapp.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Mario Arruda
 */
@Entity
public class Fisioterapeuta implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String nome;
    
    private String cpfOuCnpj;
    
    private String email;
    
    @JsonIgnore
    private String senha;
    
    private String crefito;
    
    
    
}
