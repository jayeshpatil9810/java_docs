package com.user.exception;

import org.springframework.http.HttpStatus;

public class InvalidCredentialsException extends RuntimeException {

    private HttpStatus httpStatus;

    public InvalidCredentialsException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

}
