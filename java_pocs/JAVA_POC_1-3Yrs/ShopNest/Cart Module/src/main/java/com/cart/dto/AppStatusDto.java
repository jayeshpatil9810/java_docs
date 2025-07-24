package com.cart.dto;

public class AppStatusDto {
	
	private String description;
	private String appStatusCode;
	private CartResponse cartResponse;
	
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
	public CartResponse getCartResponse() {
		return cartResponse;
	}
	public void setCartResponse(CartResponse cartResponse) {
		this.cartResponse = cartResponse;
	}

}
