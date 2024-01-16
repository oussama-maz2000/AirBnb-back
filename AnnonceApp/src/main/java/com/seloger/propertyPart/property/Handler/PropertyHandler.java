package com.seloger.propertyPart.property.Handler;

import com.seloger.propertyPart.agence.Agence;
import com.seloger.propertyPart.agence.enums.Status;
import com.seloger.propertyPart.agence.handler.AgenceHandler;
import com.seloger.propertyPart.exception.GlobalException;

import com.seloger.propertyPart.patterns.chain.Handler;
import com.seloger.propertyPart.patterns.chain.IChain;
import com.seloger.propertyPart.property.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
@Order(2)
public class PropertyHandler implements Handler<PropertyAnnonce>,PropertyHandlerInterface {
    private final PropertyMapper propertyMapper;
    private final PropertyRepository propertyRepository;
    private final AgenceHandler agenceHandler;

    public void addProperty(PropertyAnnonce propertyAnnonce) {
        try {
            Agence agence = agenceHandler.findById(2L);
            Property property = propertyMapper.mapFromPropertyRequest(propertyAnnonce.getPropertyRequest());
            property.setAgence(agence);
             propertyRepository.save(property);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw new GlobalException(ex.getMessage());
        }
    }


    public List<PropertyResponse> getPropertiesByAgenceId() {
            return propertyRepository.getPropertiesByAgenceId(2L);


    }


    public List<PropertyResponse> getAllProperties(){
        List<Property> properties=propertyRepository.findAll();
        return propertyMapper.mapFromListOfProperty(properties);
    }



    @Override
    public boolean handle(PropertyAnnonce request) {
        addProperty(request);
        return true;
    }

    @Override
    public boolean handleTwo(PropertyAnnonce request) {
        Property propertyRequest=propertyRepository.findById(request.getPropertyRequest().getID()).orElseThrow();
        if(propertyRequest!=null){
            propertyRequest=propertyMapper.mapFromPropertyRequest(request.getPropertyRequest());

            System.out.println(propertyRequest);

        }
        return true;
    }


}
