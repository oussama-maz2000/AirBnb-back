package com.seloger.propertyPart.exception;

public class AnnounceNotFoundException extends RuntimeException{

    public AnnounceNotFoundException(String errMessage){
        super(errMessage);
    }
}
