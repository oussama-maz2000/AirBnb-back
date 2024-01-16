package com.seloger.propertyPart.property;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class PropertyRequest {
    private Long ID;
    @NotNull
    private String prpType;
    @NotNull
    private String annType;
    @NotNull
    private String jrcType;
    @NotNull
    private String etatType;
    @NotNull
    private String address;
    @NotNull
    private String willaya;
    @NotNull
    private int etage;
    @NotNull
    private int facade;
    @NotNull
    private double price;
    @NotNull
    private double surface;
    private List<String> imagesLink;
    private List<String> service;
    private List<String> hygiene;
    private String piece;
    private List<String> servicePublic;
    private String climatisation;
    private String chauffage;
    private String cuisin;
    private String disponible;
    private String description;
    private String meublee;
    private String avances;
    private String etatCity;
    private String negociable;
}
