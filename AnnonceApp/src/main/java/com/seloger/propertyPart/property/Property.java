package com.seloger.propertyPart.property;

import com.seloger.propertyPart.agence.Agence;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

@Data
@Entity(name = "property")
public class Property {

    @Id
    @GeneratedValue
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
    private boolean climatisation;
    private String chauffage;
    private String cuisin;
    private String disponible;
    private String description;
    private String meublee;
    private String avances;
    private String etatCity;
    private String negociable;
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "agence_id")
    private Agence agence;
}
