package ${package}.config;

import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(basePackages = { "${package}.domain" })
@Import({ PersistenceConfig.class, SecurityConfig.class })
public class RootConfig {}