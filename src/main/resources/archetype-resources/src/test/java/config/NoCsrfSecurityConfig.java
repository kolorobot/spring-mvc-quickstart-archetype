package ${package}.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@Configuration
@Profile("test")
@Order(1)
public class NoCsrfSecurityConfig extends SecurityConfig {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
        http.csrf().disable();
    }

}
