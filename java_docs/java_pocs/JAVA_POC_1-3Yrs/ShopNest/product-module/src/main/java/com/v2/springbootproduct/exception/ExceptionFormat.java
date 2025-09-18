package com.v2.springbootproduct.exception;


public class ExceptionFormat {
    
    private String description;
    private int errorStatusCode;

    // Default Constructor
    public ExceptionFormat() {
    }

    // Parameterized Constructor
    public ExceptionFormat(String description, int errorStatusCode) {
        this.description = description;
        this.errorStatusCode = errorStatusCode;
    }

    // Getters and Setters
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getErrorStatusCode() {
        return errorStatusCode;
    }

    public void setErrorStatusCode(int errorStatusCode) {
        this.errorStatusCode = errorStatusCode;
    }

}