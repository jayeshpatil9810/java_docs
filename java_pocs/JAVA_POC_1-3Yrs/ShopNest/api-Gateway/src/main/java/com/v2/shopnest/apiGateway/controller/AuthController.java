package com.v2.shopnest.apiGateway.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final Logger LOGGER = LoggerFactory.getLogger(AuthController.class);

    @GetMapping("/login")
    public ResponseEntity<AuthResponse> login(
            @RegisteredOAuth2AuthorizedClient("okta") OAuth2AuthorizedClient client,
            @AuthenticationPrincipal OidcUser user,
            Model model)
    {
        LOGGER.info("User Principal: {}", user);
        LOGGER.info("User email id: {}", user.getEmail());
        LOGGER.info("Token: {}", client.getAccessToken().getTokenValue());
        // LOGGER.info("Refresh Token: {}", Objects.requireNonNull(client.getRefreshToken()).getTokenValue());

       AuthResponse authResponse = new AuthResponse();
        authResponse.setUserId(user.getEmail());
        authResponse.setAccessToken(client.getAccessToken().getTokenValue());
        authResponse.setRefreshToken(client.getRefreshToken().getTokenValue());
        authResponse.setExpireAt(client.getAccessToken().getExpiresAt().getEpochSecond());

        List<String> authorities = user
                .getAuthorities()
                .stream()
                .map(grantedAuthority -> {
                    return grantedAuthority.getAuthority();
                })
                .collect(Collectors.toList());

        authResponse.setAuthorities(authorities);
        System.out.println("Authorities: " + authorities);

        return new ResponseEntity<>(authResponse, HttpStatus.OK);

    }
}
