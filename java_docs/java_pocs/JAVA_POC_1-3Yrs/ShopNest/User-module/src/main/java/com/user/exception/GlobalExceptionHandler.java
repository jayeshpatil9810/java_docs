package com.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidCredentialsException.class)
    public ResponseEntity<Object> handleInvalidCredentialsException(InvalidCredentialsException e) {
        CustomExceptionFormat format = new CustomExceptionFormat(
            e.getMessage(),
            4001
        );

        return new ResponseEntity<>(format, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<Object> handleUserAlreadyExistsException(UserAlreadyExistsException e) {
        CustomExceptionFormat format = new CustomExceptionFormat(
            e.getMessage(),
            4009
        );

        return new ResponseEntity<>(format, HttpStatus.CONFLICT);
    }
}




