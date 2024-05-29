package com.demo.shutterstockApi.exception;

public class InvalidDurationFormatException extends RuntimeException {
    public InvalidDurationFormatException(String message) {
        super(message);
    }

    public InvalidDurationFormatException(String message, Throwable cause) {
        super(message, cause);
    }
}
