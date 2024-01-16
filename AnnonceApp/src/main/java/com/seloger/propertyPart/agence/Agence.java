package com.seloger.propertyPart.agence;

import com.seloger.propertyPart.agence.enums.Status;
import com.seloger.propertyPart.property.Property;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;


@Entity(name = "agence")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Agence {
    @Id
    @GeneratedValue
    private Long agenceID;
    private String agenceName;
    private String agenceEmail;
    private String agencePhoneNumber;
    private String agenceWillaya;
    private String agenceAddress;
    private String ownerFirstName;
    private String ownerLastName;
    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;
   /* @Column(name = "properties", nullable = false)
    @OneToMany(mappedBy = "agence", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Property> properties;*/


}
