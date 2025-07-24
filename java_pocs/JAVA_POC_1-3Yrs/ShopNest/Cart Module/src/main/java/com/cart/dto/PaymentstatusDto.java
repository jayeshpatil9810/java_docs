package com.cart.dto;

public class PaymentstatusDto {
	private String description;
	private String appStatusCode;
	private PaymentResponse paymentResponse;
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAppStatusCode() {
		return appStatusCode;
	}
	public void setAppStatusCode(String appStatusCode) {
		this.appStatusCode = appStatusCode;
	}
	public PaymentResponse getPaymentResponse() {
		return paymentResponse;
	}
	public void setPaymentResponse(PaymentResponse paymentResponse) {
		this.paymentResponse = paymentResponse;
	}
	
	

}
