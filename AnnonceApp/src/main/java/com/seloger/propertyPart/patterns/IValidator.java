package com.seloger.propertyPart.patterns;

import com.seloger.propertyPart.exception.GlobalResourceExceptionHandler;

import java.util.Map;

public interface IValidator <T> {
    void validator(T object) ;
}
