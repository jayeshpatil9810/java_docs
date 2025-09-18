package com.v2.shopnest.payment_module.model;

import java.io.Serializable;


public class PaymentOrder implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String status;
	private String payId;
	private String userId;
	private String redirectUrl;


	public PaymentOrder() {
		super();
	}

	public PaymentOrder(String status, String payId, String userId, String redirectUrl) {
		super();
		this.status = status;
		this.payId = payId;
		this.userId = userId;
		this.redirectUrl = redirectUrl;
	}

	public PaymentOrder(String status) {
		this.status = status;
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
	

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getRedirectUrl() {
		return redirectUrl;
	}

	public void setRedirectUrl(String redirectUrl) {
		this.redirectUrl = redirectUrl;
	}

}
