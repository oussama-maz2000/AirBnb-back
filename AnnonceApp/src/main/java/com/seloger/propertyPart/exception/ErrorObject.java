package com.seloger.propertyPart.exception;

import lombok.Data;

import java.util.Date;
import java.util.Map;

@Data
public class ErrorObject {

    private  int statusCode;
    private String errMessage;
    private Date timeStamp;
    private Map<String,String> errValidation;

    public ErrorObject(int statusCode,  Date timeStamp, Map<String, String> errValidation) {
        this.statusCode = statusCode;
        this.timeStamp = timeStamp;
        this.errValidation = errValidation;
    }

    public ErrorObject(int statusCode, String errMessage, Date timeStamp) {
        this.statusCode = statusCode;
        this.errMessage = errMessage;
        this.timeStamp = timeStamp;
    }
}

