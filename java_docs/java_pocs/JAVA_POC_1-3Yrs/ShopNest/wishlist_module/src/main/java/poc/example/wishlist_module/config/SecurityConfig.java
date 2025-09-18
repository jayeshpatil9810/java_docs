package poc.example.wishlist_module.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	

	
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests()
                .antMatchers(HttpMethod.POST, "/api/wishlist").hasAnyAuthority("Admin")
                .antMatchers(HttpMethod.DELETE, "/api/wishlist/**").hasAuthority("Admin")
                .antMatchers(HttpMethod.GET,"/api/wishlist/product/**").hasAuthority("Admin")
                .anyRequest()
                .authenticated()
                //.authenticationEntryPoint(new CustomAuthenticationEntryPoint())
                //.accessDeniedHandler(new CustomAccessDeniedHandler())
                .and()
                .oauth2ResourceServer()
                .jwt();
        return http.build();
        
    }
    
//    public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {
//        public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException)
//                throws IOException, ServletException {
//            if ((authException.getClass().isAssignableFrom(ExpiredJwtException.class))) {
//                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Token has expired");
//            } else {
//                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Authentication failed");
//            }
//        }
//
//		@Override
//		public void commence(HttpServletRequest request, HttpServletResponse response,
//				org.springframework.security.core.AuthenticationException authException)
//				throws IOException, ServletException {
//			// TODO Auto-generated method stub
//			
//		}
//    }
//
//    private static class CustomAccessDeniedHandler implements AccessDeniedHandler {
//        @Override
//        public void handle(HttpServletRequest request, HttpServletResponse response, org.springframework.security.access.AccessDeniedException accessDeniedException)
//                throws IOException, ServletException {
//            response.sendError(HttpServletResponse.SC_FORBIDDEN, "Access denied");
//        }
//    }
}