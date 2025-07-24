package com.v2.coupons_module.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.v2.coupons_module.entity.CouponsEntity;

public interface CouponsService {

	// Create Coupon
	public CouponsEntity createCoupon(CouponsEntity coupon);

	// //get Coupon by id
	// public CouponsEntity getCouponById(Long couponId);

	// get coupons by userId
	public List<CouponsEntity> getCouponByUserId(String userId);

	// get coupons by coupon code
	public CouponsEntity getCouponByCode(String couponCode);

	// get all coupons
	public List<CouponsEntity> getAllCoupons();

	// Validate Coupon
	public boolean validateCoupon(String couponCode, Double totalAmount, String userId);

	// Apply Coupon
	public double applyCoupon(String couponCode, Double totalAmount, String userId);

	// Final Cart Amount
	public double finalCartAmount(String couponCode, Double totalAmount);

	// Update Coupon isUsed by coupon code
	public String updateCouponByCode(String couponId, Boolean isUsed);

	// Delete Coupon by coupon code
    public String deleteCouponByCode(Long couponId);

    CouponsEntity updateCoupon(Long couponId, CouponsEntity coupon);
}
