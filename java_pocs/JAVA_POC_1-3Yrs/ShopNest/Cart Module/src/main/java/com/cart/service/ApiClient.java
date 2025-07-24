package com.cart.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cart.dto.OrderRequest;
//import com.v2.shopnest.payment_module.model.OrderRequest;



@FeignClient(url="http://localhost:8080/api/paypal",value="payment-module")
public interface ApiClient {
	
	@PostMapping
	public Object createOrder(@RequestBody OrderRequest orderRequest);

	
	
}