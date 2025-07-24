package com.v2.shopnest.apiGateway.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;

public class AuthResponse {
    private String userId;
    private String accessToken;
    private String refreshToken;
    private Long expireAt;
    private Collection<String> authorities;

    public AuthResponse() {
    }

    public AuthResponse(String userId, String accessToken, String refreshToken, Long expireAt, Collection<String> authorities) {
        this.userId = userId;
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.expireAt = expireAt;
        this.authorities = authorities;
    }

    public String getUserId() {
        return userId;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public Long getExpireAt() {
        return expireAt;
    }

    public Collection<String> getAuthorities() {
        return authorities;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public void setExpireAt(Long expireAt) {
        this.expireAt = expireAt;
    }

    public void setAuthorities(Collection<String> authorities) {
        this.authorities = authorities;
    }

}
