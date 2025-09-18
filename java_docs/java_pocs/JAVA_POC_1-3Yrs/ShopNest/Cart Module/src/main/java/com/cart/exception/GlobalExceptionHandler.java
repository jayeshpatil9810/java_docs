package com.cart.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProductNotAvailableException.class)
    public ResponseEntity<Object> handleProductNotAvailableException(ProductNotAvailableException e) {
        ExceptionFormat format = new ExceptionFormat(
                "4001",
                e.getMessage()


        );

        return new ResponseEntity<Object>(format, HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(UserNotLoggedInException.class)
    public ResponseEntity<Object> handleUserNotLoggedInException(UserNotLoggedInException e) {

        ExceptionFormat format = new ExceptionFormat(
                "4001",
                e.getMessage()

        );


        return new ResponseEntity<Object>(format, HttpStatus.UNAUTHORIZED);

    }

	@ExceptionHandler(InvalidCouponException.class)
	public ResponseEntity<Object> handleInvalidCouponException(InvalidCouponException e) {
		ExceptionFormat format = new ExceptionFormat(
				"4003",
				e.getMessage()

		);

		return new ResponseEntity<Object>(format, HttpStatus.BAD_REQUEST);
	}

}
