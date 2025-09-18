package com.v2.shopnest.payment_module.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.v2.shopnest.payment_module.exception.InvalidCouponException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.v2.shopnest.payment_module.config.CouponServiceClient;
import com.v2.shopnest.payment_module.model.CompletedOrder;
import com.v2.shopnest.payment_module.model.OrderRequest;
import com.v2.shopnest.payment_module.service.PaypalService;

import java.security.Principal;
import java.util.Objects;

/**
 * Controller class for handling PayPal payment operations.
 */
@RestController
@RequestMapping(value = "/api/paypal")
public class PaypalController {

	@Autowired
	private PaypalService paypalService;

	@Autowired
	private CouponServiceClient couponServiceClient;

	private Logger LOGGER = LoggerFactory.getLogger(PaypalController.class);


	/**
	 * End point for creating a PayPal order.
	 *
	 * @param amount     The payment amount.
	 * @param couponCode The coupon code (optional).
	 * @param userId     The user ID.
	 * @return PaymentOrder object representing the result of the order creation.
	 */
	@PostMapping()
	public Object createOrder(@RequestBody OrderRequest orderRequest, Principal principal) {

		orderRequest.setUserId(principal.getName());

		Double amount = orderRequest.getAmount();
		String couponCode = orderRequest.getCouponCode();
		String userId = principal.getName();

		try {
			if (!Objects.equals(couponCode, "")) {

				ResponseEntity<Object> response = couponServiceClient.applyCoupon(orderRequest);
				LOGGER.info("Response from coupon service is " + response.getBody());

				// Fetches data from JSON using its Key
				ObjectMapper mapper2 = new ObjectMapper();
				JsonNode responseJson = mapper2.convertValue(response.getBody(), JsonNode.class);
				double finalAmount = responseJson.get("finalAmount").asDouble();

				CompletedOrder completeOrder = new CompletedOrder();
				completeOrder.setCoupon(couponCode);
				return paypalService.createOrder(finalAmount, couponCode, userId);
			} else {
				return paypalService.createOrder(amount, "", userId);
			}
		} catch (Exception e) {
			throw new InvalidCouponException("Invalid coupon or criteria not met", HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}

	@GetMapping(value = "/capture/{userId}/{coupon}")
	public Object completePayment(@PathVariable(required = false) String coupon,
								  @RequestParam("token") String token,
								  @PathVariable("userId") String userId) {
		return paypalService.completePayment(token, coupon, userId);
	}

	@GetMapping(value = "/capture/{userId}")
	public Object completePayment2(@PathVariable(required = false) String coupon,
								   @RequestParam("token") String token,
								   @PathVariable String userId)
	{
		System.out.println("Coupon is " + coupon);
		return paypalService.completePayment(token, coupon, userId);
	}

	@GetMapping("/cancel")
	public ResponseEntity<String> handlePayPalCancel() {
		return ResponseEntity.ok("Cancellation");
	}

}
