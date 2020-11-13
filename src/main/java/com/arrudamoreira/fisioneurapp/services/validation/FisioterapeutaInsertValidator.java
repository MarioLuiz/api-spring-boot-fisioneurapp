package com.arrudamoreira.fisioneurapp.services.validation;

import com.arrudamoreira.fisioneurapp.domain.Fisioterapeuta;
import com.arrudamoreira.fisioneurapp.dto.FisioterapeutaNewDTO;
import com.arrudamoreira.fisioneurapp.repositories.FisioterapeutaRepository;
import com.arrudamoreira.fisioneurapp.resources.exception.FieldMessage;
import java.util.ArrayList;
import java.util.List;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author marioarruda
 */
public class FisioterapeutaInsertValidator implements ConstraintValidator<FisioterapeutaInsert, FisioterapeutaNewDTO> {

    @Autowired
    private FisioterapeutaRepository repo;

    @Override
    public void initialize(FisioterapeutaInsert constraintAnnotation) {
    }

    @Override
    public boolean isValid(FisioterapeutaNewDTO objDto, ConstraintValidatorContext context) {

        List<FieldMessage> list = new ArrayList<>();

        Fisioterapeuta aux = repo.findByEmail(objDto.getEmail());
        if (aux != null) {
            list.add(new FieldMessage("email", "Email já existe"));
        }

        list.forEach(e -> {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
                    .addConstraintViolation();
        });
        
        return list.isEmpty();

    }

}
