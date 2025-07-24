 package com.v2.shopnest.payment_module.config;

 import com.v2.shopnest.payment_module.interceptor.RestTemplateInterceptor;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.context.annotation.Bean;
 import org.springframework.context.annotation.Configuration;
 import org.springframework.http.client.ClientHttpRequestInterceptor;
 import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;
 import org.springframework.security.oauth2.client.OAuth2AuthorizedClientProvider;
 import org.springframework.security.oauth2.client.OAuth2AuthorizedClientProviderBuilder;
 import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
 import org.springframework.security.oauth2.client.web.DefaultOAuth2AuthorizedClientManager;
 import org.springframework.security.oauth2.client.web.OAuth2AuthorizedClientRepository;
 import org.springframework.web.client.RestTemplate;

 import java.util.ArrayList;
 import java.util.List;

 @Configuration
 public class ApplicationConfig {

     @Autowired
     private ClientRegistrationRepository clientRegistrationRepository;

     @Autowired
     private OAuth2AuthorizedClientRepository authorizedClientRepository;

     @Bean
     public RestTemplate restTemplate()
     {
         RestTemplate restTemplate = new RestTemplate();

         List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
         interceptors.add(new RestTemplateInterceptor(manager(
                 clientRegistrationRepository,
                 authorizedClientRepository
         )));

         restTemplate.setInterceptors(interceptors);

         return restTemplate;
     }

     @Bean
     public OAuth2AuthorizedClientManager manager(
             ClientRegistrationRepository clientRegistrationRepository,
             OAuth2AuthorizedClientRepository authorizedClientRepository
     ) {
         OAuth2AuthorizedClientProvider provider = OAuth2AuthorizedClientProviderBuilder.builder()
                 .clientCredentials()
                 .build();
         DefaultOAuth2AuthorizedClientManager defaultOAuth2AuthorizedClientManager =
                 new DefaultOAuth2AuthorizedClientManager(clientRegistrationRepository, authorizedClientRepository);
         defaultOAuth2AuthorizedClientManager.setAuthorizedClientProvider(provider);

         return defaultOAuth2AuthorizedClientManager;

     }
 }
