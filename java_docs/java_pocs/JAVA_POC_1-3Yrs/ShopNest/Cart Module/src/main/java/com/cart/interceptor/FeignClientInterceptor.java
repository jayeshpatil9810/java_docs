package com.cart.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.OAuth2AuthorizeRequest;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Configuration
@Component
public class FeignClientInterceptor implements RequestInterceptor {

    @Autowired
    private OAuth2AuthorizedClientManager manager;
    @Override
    public void apply(RequestTemplate template) {

//       String token = manager
//               .authorize(OAuth2AuthorizeRequest
//                       .withClientRegistrationId("my-internal-client")
//                       .principal("internal")
//                       .build())
//               .getAccessToken()
//               .getTokenValue();
//
//        template.header("Authorization", "Bearer " + token);
    	
    	
    	{
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            if (attributes != null) {
                HttpServletRequest request = attributes.getRequest();
                String accessToken = request.getHeader("Authorization");  // Extract token from current request
                System.out.println(accessToken);
                if (accessToken != null) {
                    template.header("Authorization",  accessToken);  // Add it to the Feign request
                }
            }
        }	
    	
    }
    	
}
