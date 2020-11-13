package com.arrudamoreira.fisioneurapp.services.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 *
 * @author marioarruda
 */

@Constraint(validatedBy = FisioterapeutaInsertValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)

public @interface FisioterapeutaInsert {
    String message() default "Erro de validação";
    
    Class<?>[] groups() default{};
    
    Class<? extends Payload>[] payload() default {};
    
}
