package com.user.service;

import com.user.entity.User;
import com.user.exception.InvalidCredentialsException;
import com.user.exception.UserAlreadyExistsException;
import com.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(User user) {
        try {
            return userRepository.save(user);
        } catch (Exception e) {
            throw new UserAlreadyExistsException("User already exists", HttpStatus.CONFLICT);
        }
    }

    public User loginUser(String username, String password) {
        User user = userRepository.findByUsername(username).orElse(null);
        if (user != null && user.getPassword().equals(password)) {
            user.setLoggedIn(true);
            userRepository.save(user);
            return user;
        } else {
            throw new InvalidCredentialsException("Invalid username or password", HttpStatus.UNAUTHORIZED);
        }
    }

    public User checkUser(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }
    
    public User logoutUser(Long userId) {
        return userRepository.findById(userId).map(user -> {
            user.setLoggedIn(false);
            userRepository.save(user);
            return user;
        }).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public ResponseEntity<Object> isUserPresent(Long userId) {
        User loggedInUser = checkUser(userId);

        if (loggedInUser != null) {
            Map<Object, Object> response = new LinkedHashMap<>();
            response.put("appStatusCode", "2000");
            response.put("description", "User found");
            response.put("user", loggedInUser);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            Map<Object, Object> response = new LinkedHashMap<>();
            response.put("appStatusCode", "2000");
            response.put("description", "User not found");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }
}


