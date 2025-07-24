package com.user.exception;

import org.springframework.http.HttpStatus;

public class UserAlreadyExistsException extends RuntimeException {

    private HttpStatus httpStatus;

    public UserAlreadyExistsException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

}
