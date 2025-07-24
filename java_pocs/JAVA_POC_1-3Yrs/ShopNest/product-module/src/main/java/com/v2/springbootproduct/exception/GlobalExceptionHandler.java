package com.v2.springbootproduct.exception;


import java.time.LocalDateTime;
import java.util.Date;

import javax.swing.RepaintManager;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.v2.springbootproduct.payload.ErrorDetails;
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{

	
	    // handle specific exceptions
	    @ExceptionHandler(ResourceNotFoundException.class)
	    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException exception,
	                                                                        WebRequest webRequest){
	        ErrorDetails errorDetails = new ErrorDetails(new Date(),exception.getMessage(),
	                webRequest.getDescription(false));
	        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	    }

	    @ExceptionHandler(ProductApiException.class)
	    public ResponseEntity<ErrorDetails> handleBlogAPIException(ProductApiException exception,
	                                                                        WebRequest webRequest){
	        ErrorDetails errorDetails = new ErrorDetails(new Date(),exception.getMessage(),
	                webRequest.getDescription(false));
	        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	    }
	    // global exceptions
	    @ExceptionHandler(Exception.class)
	    public ResponseEntity<ErrorDetails> handleGlobalException(Exception exception,
	                                                               WebRequest webRequest){
	        ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(),
	                webRequest.getDescription(false));
	        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	    }

		@ExceptionHandler(ProductNotFoundException.class)
		public ResponseEntity<Object> handleProductNotFoundException(ProductNotFoundException exception) {
			ExceptionFormat format = new ExceptionFormat(
				exception.getMessage(),            
				4004
			);

			return new ResponseEntity<Object>(format, HttpStatus.NOT_FOUND);
		}

}
