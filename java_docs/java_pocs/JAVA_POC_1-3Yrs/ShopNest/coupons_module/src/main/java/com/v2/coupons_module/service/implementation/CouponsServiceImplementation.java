package com.v2.coupons_module.service.implementation;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.v2.coupons_module.entity.CouponsEntity;
import com.v2.coupons_module.exception.CouponAlreadyExistsException;
import com.v2.coupons_module.exception.CouponNotFoundException;
import com.v2.coupons_module.repository.CouponsRepository;
import com.v2.coupons_module.service.CouponsService;

@Service
public class CouponsServiceImplementation implements CouponsService {

	@Autowired
	private CouponsRepository couponsRepo;

	@Override
	public CouponsEntity createCoupon(CouponsEntity coupon) {
		Optional<CouponsEntity> existingCoupon = couponsRepo.findByCouponCode(coupon.getCouponCode());
		if (existingCoupon.isPresent()) {
			throw new CouponAlreadyExistsException("Coupon already exists " + coupon.getCouponCode(), HttpStatus.CONFLICT);
		} 
		return couponsRepo.save(coupon);
	}

	@Override
	public List<CouponsEntity> getAllCoupons() {
		return couponsRepo.findAll();
	}

	@Override
	public CouponsEntity getCouponByCode(String couponCode) {
		Optional<CouponsEntity> optionalCoupon = couponsRepo.findByCouponCode(couponCode);
		if (optionalCoupon.isPresent()) {
			return optionalCoupon.get();
		} else {
			throw new CouponNotFoundException("Coupon not found with coupon code " + couponCode, HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public List<CouponsEntity> getCouponByUserId(String userId) {
		return couponsRepo.findByUserId(userId);
	}

	@Override
	public boolean validateCoupon(String couponCode, Double totalAmount, String userId) {
		/**
		 * 1. If coupon exists in the DB
		 * 2. if coupon has been used or not
		 * 3. if coupon is in the validity period
		 * 4. Correct User is applying the coupon
		 * 5. Total amount should be greater than 1000
		 */
		Optional<CouponsEntity> optionalCoupon = couponsRepo.findByCouponCode(couponCode);
		if (!optionalCoupon.isPresent()) {
			return false; // coupon not present
		}

		CouponsEntity coupon = optionalCoupon.get();

		if (coupon.isUsed()) {
			return false; // Coupon has already been used
		}

		LocalDateTime currentDate = LocalDateTime.now();
		if (currentDate.isAfter(coupon.getValidTill())) {
			return false; // Coupon is expired
		}

		if (totalAmount < 1000) {
			return false; // discountAmount is less than 1000
		}

		if (userId != null) {
			if (!userId.equals(coupon.getUserId())) {
				return false;
			}
		}

		return true;
	}

	@Override
	public double applyCoupon(String couponCode, Double totalAmount, String userId) {
		if (validateCoupon(couponCode, totalAmount, userId)) {
			return finalCartAmount(couponCode, totalAmount);
		} else {
			return totalAmount;
		}

	}

	@Override
	public double finalCartAmount(String couponCode, Double totalAmount) {
		Optional<CouponsEntity> optionalCoupon = couponsRepo.findByCouponCode(couponCode);
		CouponsEntity coupon = optionalCoupon.get();
        return totalAmount * (1 - (coupon.getDiscount() / 100));

	}

	@Override
	public String updateCouponByCode(String couponCode, Boolean isUsed) {
		Optional<CouponsEntity> optionalCoupon = couponsRepo.findByCouponCode(couponCode);
		if (optionalCoupon.isPresent()) {
			CouponsEntity coupon = optionalCoupon.get();
			coupon.setUsed(isUsed);
			couponsRepo.save(coupon);
			return "Updated Successfully";
		} else {
			throw new CouponNotFoundException("Coupon not found with coupon " + couponCode, HttpStatus.NOT_FOUND);
		}
	}

	// Auto deletes coupon post expiry. Scheduled to run everyday at 12:01 AM
	@Scheduled(cron = "0 1 0 * * ?")
	public void checkCouponValidity() {
		List<CouponsEntity> expiredCoupons = couponsRepo.findByValidTillBeforeAndIsUsedFalse(LocalDateTime.now());
		for (CouponsEntity coupon : expiredCoupons) {
			coupon.setUsed(true);
			couponsRepo.save(coupon);
		}
	}

	@Override
	public String deleteCouponByCode(Long couponId) {
		Optional<CouponsEntity> optionalCoupon = couponsRepo.findById(couponId);
		if (optionalCoupon.isPresent()) {
			couponsRepo.delete(optionalCoupon.get());
			return "Coupon Deleted Successfully";
		} else {
			throw new CouponNotFoundException("Coupon not found with Id " + couponId, HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public CouponsEntity updateCoupon(Long couponId, CouponsEntity coupon) {
		Optional<CouponsEntity> optionalCoupon = couponsRepo.findById(couponId);
		if (optionalCoupon.isPresent()) {
			CouponsEntity couponToUpdate = optionalCoupon.get();
			couponToUpdate.setCouponCode(coupon.getCouponCode());
			couponToUpdate.setDiscount(coupon.getDiscount());
			couponToUpdate.setValidTill(coupon.getValidTill());
			couponToUpdate.setUsed(coupon.isUsed());
			couponToUpdate.setUserId(coupon.getUserId());
			couponsRepo.save(couponToUpdate);
			return couponToUpdate;
		} else {
			throw new CouponNotFoundException("Coupon not found with Id " + couponId, HttpStatus.NOT_FOUND);
		}
	}

}
