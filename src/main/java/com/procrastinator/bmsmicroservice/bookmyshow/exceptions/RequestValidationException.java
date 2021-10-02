package com.procrastinator.bmsmicroservice.bookmyshow.exceptions;

import lombok.Data;

@Data
public class RequestValidationException extends Exception{

    private String errorCode;
    private String errorMessage;


    public RequestValidationException(String  errorCode,String errorMessage){
        this.errorCode=errorCode;
        this.errorMessage=errorMessage;
    }
}
