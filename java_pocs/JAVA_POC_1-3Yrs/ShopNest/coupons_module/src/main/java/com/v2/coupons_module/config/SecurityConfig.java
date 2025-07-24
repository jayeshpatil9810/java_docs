package com.v2.coupons_module.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
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
                    .antMatchers(HttpMethod.POST, "/api/coupons").hasAuthority("Admin") // Create Coupon(Admin)
                    .antMatchers(HttpMethod.GET, "/api/coupons").hasAuthority("Admin") // Get all coupons(Admin)
                    .antMatchers(HttpMethod.GET, "/api/coupons/userid/{id}").hasAuthority("Admin") // Fetch coupons by used id(Admin)
                    .antMatchers(HttpMethod.GET, "/api/coupons/mycoupons").hasAuthority("Normal") // Get all coupons of a particular user using the token(Normal User)
                    .antMatchers(HttpMethod.POST, "/api/coupons/validate").hasAuthority("Normal") // Validate the coupon(Normal User)
                    .antMatchers(HttpMethod.POST, "/api/coupons/apply").hasAnyAuthority("Normal") // Apply Coupon(Normal User)
//                    .antMatchers(HttpMethod.PUT, "/api/coupons/update/{code}").hasAnyAuthority("Admin", "SCOPE_internal") // Update Coupon(Admin)
                    .antMatchers(HttpMethod.DELETE, "/api/coupons/{id}").hasAuthority("Admin") // Delete Coupon(Admin)
                    .antMatchers(HttpMethod.PUT, "/api/coupons/{id}").hasAuthority("Admin") // Update Coupon(Admin)
                .anyRequest()
                .authenticated()
                .and()
                .oauth2ResourceServer()
                .jwt();

        return http.build();
    }
}
