package com.cart.dto;

public class PaymentResponse {
	
	
	private String status;
	private String payId;
	private Long userId;
	private String redirectUrl;
	
	

   	
	
	public PaymentResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PaymentResponse(String status, String payId, Long userId, String redirectUrl) {
		super();
		this.status = status;
		this.payId = payId;
		this.userId = userId;
		this.redirectUrl = redirectUrl;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPayId() {
		return payId;
	}

	public void setPayId(String payId) {
		this.payId = payId;
	}
	

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getRedirectUrl() {
		return redirectUrl;
	}

	public void setRedirectUrl(String redirectUrl) {
		this.redirectUrl = redirectUrl;
	}

}
