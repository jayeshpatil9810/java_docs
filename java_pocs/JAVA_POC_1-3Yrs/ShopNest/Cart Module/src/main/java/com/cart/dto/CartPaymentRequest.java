package com.cart.dto;

public class CartPaymentRequest {
	
	//private Double amount;
	private String couponCode;
	public String userId;

	

	public String getCouponCode() {
		return couponCode;
	}

	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}


}
