package com.v2.coupons_module.exception;

public class ExceptionFormat {

    private int httpCode;
    private String errorMessage;

    // Default Constructor
    public ExceptionFormat() {
    }

    // AllArgsConstructor
    public ExceptionFormat(int httpCode, String errorMessage ) {
        this.errorMessage = errorMessage;
        this.httpCode = httpCode;
    }

    // Getter and Setter
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
