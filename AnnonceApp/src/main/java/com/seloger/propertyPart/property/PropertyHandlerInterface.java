package com.seloger.propertyPart.property;

import java.util.List;

public interface PropertyHandlerInterface {
    public void addProperty(PropertyAnnonce propertyAnnonce);

    public List<PropertyResponse> getPropertiesByAgenceId();

    public List<PropertyResponse> getAllProperties();
}
