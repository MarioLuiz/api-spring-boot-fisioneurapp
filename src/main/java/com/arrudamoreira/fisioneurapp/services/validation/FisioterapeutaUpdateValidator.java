package com.arrudamoreira.fisioneurapp.services.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import com.arrudamoreira.fisioneurapp.domain.Fisioterapeuta;
import com.arrudamoreira.fisioneurapp.dto.FisioterapeutaDTO;
import com.arrudamoreira.fisioneurapp.repositories.FisioterapeutaRepository;
import com.arrudamoreira.fisioneurapp.resources.exception.FieldMessage;

public class FisioterapeutaUpdateValidator implements ConstraintValidator<FisioterapeutaUpdate, FisioterapeutaDTO> {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private FisioterapeutaRepository repo;

    @Override
    public void initialize(FisioterapeutaUpdate ann) {
    }

    @Override
    public boolean isValid(FisioterapeutaDTO objDto, ConstraintValidatorContext context) {

        @SuppressWarnings("unchecked")
        Map<String, String> map = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
        Integer uriId = Integer.parseInt(map.get("id"));

        List<FieldMessage> list = new ArrayList<>();

        Fisioterapeuta aux = repo.findByEmailIgnoreCase(objDto.getEmail());
        if (aux != null && !aux.getId().equals(uriId)) {
            list.add(new FieldMessage("email", "Email já existente"));
        }

        for (FieldMessage e : list) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
                    .addConstraintViolation();
        }
        return list.isEmpty();
    }
}
