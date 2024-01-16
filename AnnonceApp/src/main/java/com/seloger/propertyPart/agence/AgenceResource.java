package com.seloger.propertyPart.agence;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/agence")
@AllArgsConstructor
public class AgenceResource {
private final AgenceService agenceService;
    @GetMapping(value = "create-agence")
    public void createAgence(){
        agenceService.createTmpAgence();
    }
}
