package com.v2.coupons_module.exception;

import org.springframework.http.HttpStatus;

public class UserIsNotAuthenticated extends RuntimeException{

    private HttpStatus httpStatus;

    public UserIsNotAuthenticated(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
