package com.seloger.propertyPart.property;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PropertyMapper {

    @Mapping(target = "ID", ignore = true)
   /* @Mapping(target = "imagesLink", ignore = true)*/
    Property mapFromPropertyRequest(PropertyRequest propertyRequest);


    @Mapping(target = "agence",ignore = false)
    List<PropertyResponse> mapFromListOfProperty(List<Property> properties);
}
