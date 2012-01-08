package ${package}.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:persistence.properties")
public class PersistanceContext implements TransactionManagementConfigurer {
	
	private static final String PASSWORD_PROPERTY = "dataSource.password";
	private static final String USERNAME_PROPERTY = "dataSource.username";
	private static final String URL_PROPERTY = "dataSource.url";
	private static final String DRIVER_CLASS_NAME_PROPERTY = "dataSource.driverClassName";
	
	@Autowired
    private Environment env;
	
	@Bean
	public DataSource configureDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getProperty(DRIVER_CLASS_NAME_PROPERTY));
		dataSource.setUrl(env.getProperty(URL_PROPERTY));
		dataSource.setUsername(env.getProperty(USERNAME_PROPERTY));
		dataSource.setPassword(env.getProperty(PASSWORD_PROPERTY));
		return dataSource;
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean configureEntityManagerFactory() {
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setDataSource(configureDataSource());
		entityManagerFactoryBean.setPackagesToScan("${package}.domain");
		entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		
		Properties jpaProperties = new Properties();
		jpaProperties.put(org.hibernate.cfg.Environment.DIALECT, env.getProperty(org.hibernate.cfg.Environment.DIALECT));
		jpaProperties.put(org.hibernate.cfg.Environment.HBM2DDL_AUTO, env.getProperty(org.hibernate.cfg.Environment.HBM2DDL_AUTO));
		entityManagerFactoryBean.setJpaProperties(jpaProperties);
		
		return entityManagerFactoryBean;
	}

	@Bean	
	public PlatformTransactionManager annotationDrivenTransactionManager() {
		return new JpaTransactionManager();
	}

}
