package com.seloger.propertyPart.agence.handler;

import com.seloger.propertyPart.agence.Agence;
import com.seloger.propertyPart.agence.AgenceRepository;
import com.seloger.propertyPart.agence.enums.Status;
import com.seloger.propertyPart.property.Property;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class AgenceHandler {

    private final AgenceRepository agenceRepository;

    public Agence addAgence(Agence agence) {
        return agenceRepository.save(agence);
    }

    public Agence findById(Long id){
        Agence agence= agenceRepository.findById(id).orElse(null);
        System.out.println(agence);
        return agence;
    }


    public void createTmpAgence(){
        Agence agence = Agence.builder()
                .agenceEmail("test@gmail.com")
                .agenceAddress("5 juillet")
                .agenceName("El Test")
                .agenceWillaya("Batna")
                .agencePhoneNumber("0798786856")
                .ownerLastName("John")
                .ownerFirstName("Paul")
                .status(Status.Block)
                .build();
        agenceRepository.save(agence);
    }


    public void updatePropertyId(Property property){

    }
}
