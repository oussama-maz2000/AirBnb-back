package com.seloger.propertyPart.agence;


import com.seloger.propertyPart.agence.handler.AgenceHandler;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AgenceService {
    private final AgenceHandler agenceHandler;

    public void createTmpAgence(){
        agenceHandler.createTmpAgence();
    }
}
