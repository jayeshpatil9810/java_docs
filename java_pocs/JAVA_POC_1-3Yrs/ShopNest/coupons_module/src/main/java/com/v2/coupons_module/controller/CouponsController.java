package com.v2.coupons_module.controller;

import java.security.Principal;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.v2.coupons_module.dto.ValidateDTO;
import com.v2.coupons_module.entity.CouponsEntity;
import com.v2.coupons_module.exception.InvalidCouponException;
import com.v2.coupons_module.service.CouponsService;

/*
 *All the controllers are listed below: 
 *1. createCoupon(Creates Coupon) (POST)  (/api/coupons/createcoupon)
 *2. getCouponById(gets coupon by id) (GET) (/api/coupons/{id}
 *3. getCouponByUserId(gets coupon by user id) (GET) (/api/coupons/userid/{id}
 *4. validateCoupon(Validates coupon on the basis of coupon code, total amount, validity and user id) (GET) (/api/coupons/validate)
 *5. applyCoupon(Applies coupon code and returns the final amount) (GET) (/api/coupons/apply)
 *6. finalCartAmount(Calculates the final amount after applying coupon) (GET) (/api/coupons/finalcartamount
 *7. updateCouponByCode(updates coupon by isUsed field) (PUT) (/api/coupons/update/{code})
 *8. checkCouponValidity (Auto deletes coupon post expiry) (SCHEDULED) (/api/coupons/checkcouponvalidity)
*/

@RestController
@RequestMapping("/api/coupons")
public class CouponsController {

	@Autowired
	private CouponsService couponService;


	// Create Coupon(Admin)
	@PostMapping()
	public ResponseEntity<Object> createCoupon(@RequestBody CouponsEntity coupon) {

		CouponsEntity createdCoupon = couponService.createCoupon(coupon);
		LinkedHashMap<Object, Object> response = new LinkedHashMap<>();
		response.put("appStatusCode", "2001");
		response.put("description", "Coupon created successfully");
		response.put("coupon", createdCoupon);

		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}


	//Get all coupons(Admin)
	@GetMapping()
	public List<CouponsEntity> getAllCoupons() {
		return couponService.getAllCoupons();
	}


	//Fetch Coupons by coupon code(Admin)
	@GetMapping("/{code}")
	public CouponsEntity getCouponsByCode(@PathVariable("code") String couponCode) {
		return couponService.getCouponByCode(couponCode);
	}


	// Fetch coupons by used id(Admin)
	@GetMapping("/userid/{id}")
	public List<CouponsEntity> getCouponsByUserId(@PathVariable("id") String userId) {
		return couponService.getCouponByUserId(userId);
	}

	// Get all coupons of a particular user using the token(Normal User)
	@GetMapping("/mycoupons")
	public List<CouponsEntity> getMyCoupons(Principal principal) {
		return couponService.getCouponByUserId(principal.getName());
	}


	// Validate the coupon(Normal User)
	@PostMapping("/validate")
	public ResponseEntity<Object> validateCoupon(@RequestBody ValidateDTO validateDTO, Principal principal)
	{

		validateDTO.setUserId(principal.getName());
		boolean isValid = couponService.validateCoupon(validateDTO.getCouponCode(), validateDTO.getAmount(),
				validateDTO.getUserId());

		if (isValid) {
			LinkedHashMap<Object, Object> response = new LinkedHashMap<>();
			response.put("appStatusCode", "2000");
			response.put("description", "Coupon is valid");
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			throw new InvalidCouponException("Invalid coupon or criteria not met", HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}


	// Normal User
	@PostMapping("/apply")
	public ResponseEntity<Object> applyCoupon(@RequestBody ValidateDTO validateDTO, Principal principal) {

		validateDTO.setUserId(principal.getName());

		//Getting the total amount and final amount
  		double totalAmount = validateDTO.getAmount();
		double finalAmount = couponService.applyCoupon(validateDTO.getCouponCode(), validateDTO.getAmount(), validateDTO.getUserId());

		if (finalAmount != totalAmount) {
			LinkedHashMap<Object, Object> response = new LinkedHashMap<>();
			response.put("appStatusCode", "2000");
			response.put("description", "Coupon applied successfully");
			response.put("finalAmount", finalAmount);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			throw new InvalidCouponException("Invalid coupon or criteria not met", HttpStatus.BAD_REQUEST);
		}
	}

	//Admin
	@PutMapping("/update/{code}")
	public String updateCouponByCode(@PathVariable("code") String couponCode,
									 @RequestBody Boolean isUsed) 
	{
		return couponService.updateCouponByCode(couponCode, isUsed);
	}

	//Admin
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteCouponByCode(@PathVariable("id") Long couponId) {
		String deleteCoupon = couponService.deleteCouponByCode(couponId);
		LinkedHashMap<Object, Object> response = new LinkedHashMap<>();
		response.put("appStatusCode", "2000");
		response.put("description", deleteCoupon);

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	//update coupon(Admin)
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateCoupon(@PathVariable("id") Long couponId, @RequestBody CouponsEntity coupon) {
		CouponsEntity updatedCoupon = couponService.updateCoupon(couponId, coupon);
		LinkedHashMap<Object, Object> response = new LinkedHashMap<>();
		response.put("appStatusCode", "2000");
		response.put("description", "Coupon updated successfully");
		response.put("coupon", updatedCoupon);

		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
