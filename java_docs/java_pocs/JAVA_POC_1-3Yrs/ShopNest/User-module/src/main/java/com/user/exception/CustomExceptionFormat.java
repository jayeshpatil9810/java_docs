package com.user.exception;

public class CustomExceptionFormat {

    private String errorMessage;
    private int httpCode;

    // Default Constructor
    public CustomExceptionFormat() {
    }

    // AllArgsConstructor
    public CustomExceptionFormat(String errorMessage, int httpCode) {
        this.errorMessage = errorMessage;
        this.httpCode = httpCode;
    }

    // Getter and Setter methods

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public int getHttpCode() {
        return httpCode;
    }

    public void setHttpCode(int httpCode) {
        this.httpCode = httpCode;
    }
}




