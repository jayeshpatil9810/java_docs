package com.v2.springbootproduct.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import com.v2.springbootproduct.exception.CustomAuthenticationEntryPoint;

import org.springframework.security.config.Customizer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http
                .authorizeHttpRequests()
                    .antMatchers(HttpMethod.POST, "/api/product").hasAnyAuthority("Admin")
                    .antMatchers(HttpMethod.DELETE, "/api/product/**").hasAuthority("Admin")
                    .antMatchers(HttpMethod.PUT, "/api/product/**").hasAuthority("Admin")
                .anyRequest()
                .authenticated()
                .and()
                .oauth2ResourceServer()
                .jwt();

        return http.build();
    }
}
