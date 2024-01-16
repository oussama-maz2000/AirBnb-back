package com.seloger.propertyPart.property;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PropertyResponse {
    private Long ID;
    private String prpType;
    private String annType;
    private String jrcType;
    private String etatType;
    private String address;
    private String willaya;
    private int etage;
    private int facade;
    private double price;
    private double surface;
    private List<String> imagesLink;
    private List<String> service;
    private List<String> hygiene;
    private String piece;
    private List<String> servicePublic;
    private boolean climatisation;
    private String chauffage;
    private String cuisin;
    private String disponible;
    private String description;
    private String meublee;
    private String avances;
    private String etatCity;
    private String negociable;
}
