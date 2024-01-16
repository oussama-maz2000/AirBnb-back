package com.seloger.propertyPart.property;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Long> {

    @Query("SELECT new com.seloger.propertyPart.property.PropertyResponse(p.ID,p.prpType,p.annType,p.jrcType,p.etatType,p.address,p.willaya,p.etage,p.facade,p.price,p.surface,p.imagesLink,p.service,p.hygiene,p.piece,p.servicePublic,p.climatisation,p.chauffage,p.cuisin,p.disponible,p.description,p.meublee,p.avances,p.etatCity,p.negociable) FROM property p WHERE p.agence.agenceID = :agence_id")
    List<PropertyResponse> getPropertiesByAgenceId(@Param("agence_id") Long agence_id);

    List<Property> findByAgenceAgenceID(Long agenceID);
}
