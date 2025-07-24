package com.v2.springbootproduct.payload;

import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.http.HttpStatus;

public class ErrorDetails {

	
	 private Date timestamp;
	    private String message;
	    private String details;

	    public ErrorDetails(Date timestamp, String message, String details) {
	        this.timestamp = timestamp;
	        this.message = message;
	        this.details = details;
	    }

	    public Date getTimestamp() {
	        return timestamp;
	    }

	    public String getMessage() {
	        return message;
	    }

	    public String getDetails() {
	        return details;
	    }
	   
}
