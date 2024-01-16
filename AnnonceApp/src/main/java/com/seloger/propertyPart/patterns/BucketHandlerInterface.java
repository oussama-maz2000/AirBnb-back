package com.seloger.propertyPart.patterns;

import com.seloger.propertyPart.property.PropertyAnnonce;

import java.util.List;

public interface BucketHandlerInterface {
    public PropertyAnnonce saveImagesOnStorage(PropertyAnnonce propertyAnnonce);

    public void deleteImagesFromBucket(List<String> imagesPath);
}
