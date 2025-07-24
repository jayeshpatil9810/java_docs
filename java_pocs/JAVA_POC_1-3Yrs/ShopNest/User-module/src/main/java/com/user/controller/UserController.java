package com.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.user.entity.User;
import com.user.exception.InvalidCredentialsException;
import com.user.service.UserService;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    //http://localhost:9090/api/users/register
    @PostMapping("/register")
    public ResponseEntity<Object> registerUser(@RequestBody User user) {
        User registeredUser = userService.registerUser(user);
        Map<Object, Object> response = new LinkedHashMap<>();
        response.put("appStatusCode", "2001");
        response.put("description", "User registered successfully");
        response.put("user", registeredUser);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    

    //http://localhost:9090/api/users/login
    @PostMapping("/login")
    public ResponseEntity<Object> loginUser(@RequestBody User user) {
        User loggedInUser = userService.loginUser(user.getUsername(), user.getPassword());

        if (loggedInUser != null) {
        	Map<Object, Object> response = new LinkedHashMap<>();
            response.put("appStatusCode", "2000");
            response.put("description", "User logged in successfully");
            response.put("user", loggedInUser);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            throw new InvalidCredentialsException("Invalid username or password", HttpStatus.UNAUTHORIZED);
        }
    }

    //http://localhost:9090/api/users/logout
    @GetMapping("/logout/{userId}")
    public ResponseEntity<Object> logoutUser(@PathVariable Long userId) {
        User loggedOutUser = userService.logoutUser(userId);
        Map<Object, Object> response = new LinkedHashMap<>();
        response.put("appStatusCode", "2000");
        response.put("description", "User logged out successfully");
        response.put("user", loggedOutUser);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    
    @PostMapping("/checkuser/{userId}")
    public ResponseEntity<?> isUserPresent(@PathVariable Long userId) {
    	User loggedInUser = userService.checkUser(userId);
    	if (loggedInUser != null) {
    		return ResponseEntity.ok(loggedInUser);
    		} else {
    			return ResponseEntity.ok(null);
    		}
    }
}



