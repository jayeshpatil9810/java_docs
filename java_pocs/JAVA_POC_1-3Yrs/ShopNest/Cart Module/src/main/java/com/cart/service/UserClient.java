package com.cart.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.cart.model.User;

@FeignClient(url="http://localhost:9090",value="User-module")
public interface UserClient {

	@PostMapping("/api/users/checkuser/{userId}")
    User loginUser(@PathVariable Long userId);
	
	@GetMapping("/api/users/{userId}")
	User getUserById(@PathVariable Long userId);
}
