package com.seloger.propertyPart.property.Handler;

import com.seloger.propertyPart.exception.GlobalException;
import com.seloger.propertyPart.patterns.chain.Handler;
import com.seloger.propertyPart.property.PropertyAnnonce;
import lombok.AllArgsConstructor;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.validation.*;

import java.util.HashMap;
import java.util.Map;

@Component
@AllArgsConstructor
@Order(0)
public class validationHandler implements  Handler<PropertyAnnonce> {
    private final Validator validator;


    public void validator(PropertyAnnonce object) {
        Map<String,String> fieldErrors=new HashMap<>();
        DataBinder binder = new DataBinder(object.getPropertyRequest());
        binder.setValidator(validator);
        binder.validate();
        binder.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();

            fieldErrors.put(fieldName, errorMessage);

        });
        if(!fieldErrors.isEmpty()){
            throw new GlobalException("vous avez une erreur dans la formulaire ");
        }

    }

    @Override
    public boolean handle(PropertyAnnonce request) {
        validator(request);
        return false;
    }

    @Override
    public boolean handleTwo(PropertyAnnonce request) {
        validator(request);
        return false;
    }
}
