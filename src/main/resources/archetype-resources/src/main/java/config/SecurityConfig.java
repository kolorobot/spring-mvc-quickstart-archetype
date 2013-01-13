package ${package}.config;

import org.springframework.context.annotation.*;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.rememberme.TokenBasedRememberMeServices;

import ${package}.account.UserService;

@Configuration
@ImportResource(value = "classpath:spring-security-context.xml")
public class SecurityConfig {
	
	@Bean
	public UserDetailsService userService() {
		return new UserService();
	}

	@Bean
	public TokenBasedRememberMeServices rememberMeServices() {
		return new TokenBasedRememberMeServices("remember-me-key", userService());
	}
}