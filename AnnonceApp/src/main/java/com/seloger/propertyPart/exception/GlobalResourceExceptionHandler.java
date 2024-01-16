package com.seloger.propertyPart.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalResourceExceptionHandler {

    @ExceptionHandler(AnnounceNotFoundException.class)
    public ResponseEntity<ErrorObject> handlePropertyException(AnnounceNotFoundException exception, WebRequest webRequest) {
        ErrorObject errorObject = new ErrorObject(HttpStatus.NOT_FOUND.value(), exception.getMessage(), new Date());
        return new ResponseEntity<ErrorObject>(errorObject, HttpStatus.NOT_FOUND);
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorObject> handleValidationErrors(MethodArgumentNotValidException error) {
        Map<String, String> errResult = new HashMap<>();

        error.getBindingResult().getAllErrors().forEach((err) -> {
            String fieldName = ((FieldError) err).getField();
             String message = err.getDefaultMessage();
            errResult.put(fieldName, message);
        });
        ErrorObject errorObject = new ErrorObject(HttpStatus.NOT_ACCEPTABLE.value(), new Date(),errResult);
        return new ResponseEntity<ErrorObject>(errorObject, HttpStatus.NOT_ACCEPTABLE);


    }



    @ExceptionHandler(GlobalException.class)
    public ResponseEntity<Object> handleValidationException(GlobalException exception) {
HttpStatus httpStatus=HttpStatus.BAD_REQUEST;
ApiException apiException=new ApiException(exception.getMessage(),httpStatus, ZonedDateTime.now(ZoneId.of("Z")));
return new ResponseEntity<>(apiException,httpStatus);

    }

}
