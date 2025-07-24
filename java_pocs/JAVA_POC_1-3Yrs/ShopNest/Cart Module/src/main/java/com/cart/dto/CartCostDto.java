package com.cart.dto;

public class CartCostDto {
	private String description;
	private String appStatusCode;
	private Double totalCost;
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
	public Double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(Double totalCost) {
		this.totalCost = totalCost;
	}
	

}
