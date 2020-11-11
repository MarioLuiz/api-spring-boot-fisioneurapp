package com.arrudamoreira.fisioneurapp.resources.validation;

import javax.validation.Payload;

/**
 *
 * @author marioarruda
 */
public @interface FisioterapeutaInsert {
    String message() default "Erro de validação";
    
    Class<?>[] groups() default{};
    
    Class<? extends Payload>[] payload() default {};
    
}
