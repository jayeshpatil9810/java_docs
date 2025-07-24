package com.v2.shopnest.payment_module.config;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.v2.shopnest.payment_module.model.OrderRequest;

@FeignClient(name = "couponService", url = "http://localhost:8081/api/coupons")  //, value = "coupons_module"
public interface CouponServiceClient {

    @PostMapping("/apply")
    ResponseEntity<Object> applyCoupon(@RequestBody OrderRequest orderRequest);

    @PutMapping("/update/{code}")
    public String updateCouponByCode(@PathVariable("code") String couponCode, @RequestBody boolean isUsed);

}
