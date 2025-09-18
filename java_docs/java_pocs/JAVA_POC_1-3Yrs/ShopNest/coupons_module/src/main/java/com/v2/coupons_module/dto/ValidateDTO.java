package com.v2.coupons_module.dto;

public class ValidateDTO {

    private String couponCode;
    private String userId;
    private double amount;

    public ValidateDTO() {
    }

    public ValidateDTO(String couponCode, String userId, double amount) {
        this.couponCode = couponCode;
        this.userId = userId;
        this.amount = amount;
    }

    public String getCouponCode() {
        return this.couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

}
