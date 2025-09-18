package com.v2.shopnest.payment_module.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidCouponException.class)
    public ResponseEntity<Object> handleInvalidCouponException(InvalidCouponException e) {
        ExceptionFormat format = new ExceptionFormat(
                4022,
                e.getMessage()

        );

        return new ResponseEntity<Object>(format, HttpStatus.BAD_REQUEST);
    }
}
