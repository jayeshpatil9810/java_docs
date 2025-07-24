package com.v2.coupons_module.exception;

import org.springframework.http.HttpStatus;

public class CouponAlreadyExistsException extends RuntimeException {

    private HttpStatus httpStatus;
    
    public CouponAlreadyExistsException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

}
