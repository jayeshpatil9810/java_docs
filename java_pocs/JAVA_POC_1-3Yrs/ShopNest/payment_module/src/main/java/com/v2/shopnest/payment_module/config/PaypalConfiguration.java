package com.v2.shopnest.payment_module.config;

import com.paypal.core.PayPalEnvironment;
import com.paypal.core.PayPalHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PaypalConfiguration {

    @Bean
    public PayPalHttpClient getPaypalClient(
            @Value("${paypal.clientId}") String clientId,
            @Value("${paypal.clientSecret}") String clientSecret) {

               // Configure to send token in Header as required by PayPal

               
        return new PayPalHttpClient(new PayPalEnvironment.Sandbox(clientId, clientSecret));

    }
}
