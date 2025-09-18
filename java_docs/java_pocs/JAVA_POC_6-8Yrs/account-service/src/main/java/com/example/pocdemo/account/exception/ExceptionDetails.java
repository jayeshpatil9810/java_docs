package com.example.pocdemo.account.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ExceptionDetails {

    private String errorCode;
    private String message;

    ExceptionDetails(String errorCode, String message){
        this.errorCode=errorCode;
        this.message=message;
    }
}
