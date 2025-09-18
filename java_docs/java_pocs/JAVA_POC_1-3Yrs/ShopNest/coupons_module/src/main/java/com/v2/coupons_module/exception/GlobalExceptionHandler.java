package com.v2.coupons_module.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CouponAlreadyExistsException.class)
    public ResponseEntity<Object> handleCouponAlreadyExistsException(CouponAlreadyExistsException e) {
        ExceptionFormat format = new ExceptionFormat(
                4009,
                e.getMessage()

        );

        return new ResponseEntity<Object>(format, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(CouponNotFoundException.class)
    public ResponseEntity<Object> handleCouponNotFoundException(CouponNotFoundException e) {
        ExceptionFormat format = new ExceptionFormat(
                4004,
                e.getMessage()

        );

        return new ResponseEntity<Object>(format, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidCouponException.class)
    public ResponseEntity<Object> handleInvalidCouponException(InvalidCouponException e) {
        ExceptionFormat format = new ExceptionFormat(
                4022,
                e.getMessage()

        );

        return new ResponseEntity<Object>(format, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(UserIsNotAuthenticated.class)
    public ResponseEntity<Object> handleUserIsNotAuthenticated(UserIsNotAuthenticated e) {
        ExceptionFormat format = new ExceptionFormat(
                4003,
                e.getMessage()

        );

        return new ResponseEntity<Object>(format, HttpStatus.UNAUTHORIZED);
    }
}