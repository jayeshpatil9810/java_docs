package com.v2.shopnest.payment_module.exception;

public class PaypalCaptureException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PaypalCaptureException(String message, Throwable cause) {
		super(message, cause);
	}
}
