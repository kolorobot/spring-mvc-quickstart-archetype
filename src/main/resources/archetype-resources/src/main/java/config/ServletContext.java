package ${package}.config;

import org.springframework.context.annotation.*;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.tiles2.TilesConfigurer;
import org.springframework.web.servlet.view.tiles2.TilesViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "${package}" }, excludeFilters = @Filter(type = FilterType.ANNOTATION, value = Configuration.class))
@Import(PersistanceContext.class)
public class ServletContext extends WebMvcConfigurerAdapter {
	
	
	@Bean
    public TilesViewResolver configureTilesViewResolver() {
        return new TilesViewResolver();
    }
	
	@Bean
    public TilesConfigurer configureTilesConfigurer() {
        TilesConfigurer configurer = new TilesConfigurer();
        configurer.setDefinitions(new String[] {"/WEB-INF/tiles/tiles.xml", "/WEB-INF/views/**/views.xml"});
        return configurer;
    }
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/").addResourceLocations("/recourses/**");
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
}
