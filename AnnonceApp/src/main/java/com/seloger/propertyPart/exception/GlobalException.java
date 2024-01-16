package com.seloger.propertyPart.exception;


public class GlobalException extends RuntimeException{
    private String fieldErrors;

    public GlobalException(String fieldErrors){
        super(fieldErrors);
    }

}
