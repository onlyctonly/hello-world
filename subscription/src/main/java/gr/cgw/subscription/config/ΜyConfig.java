package gr.cgw.subscription.config;

import java.beans.PropertyVetoException;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="gr.cgw.subscription")
@PropertySource("classpath:persistence-mysql.properties")
public class ΜyConfig {
	
	@Autowired
	private Environment env;
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Bean
	public ViewResolver viewresolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
	@Bean
	public DataSource securityDataSource() {
		ComboPooledDataSource securitydatasource = new ComboPooledDataSource();
		try {
			securitydatasource.setDriverClass(env.getProperty("jdbc.driver"));
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
		logger.info("===jdbc.url: " + env.getProperty("jdbc.url"));
		logger.info("===jdbc.user: " + env.getProperty("jdbc.username"));
		
		securitydatasource.setJdbcUrl(env.getProperty("jdbc.url"));
		securitydatasource.setUser(env.getProperty("jdbc.username"));
		securitydatasource.setPassword(env.getProperty("jdbc.password"));
		
		securitydatasource.setInitialPoolSize(getIntProperty("connection.pool.initialpoolsize"));
		securitydatasource.setMinPoolSize(getIntProperty("connection.pool.minpoolsize"));
		securitydatasource.setMaxPoolSize(getIntProperty("connection.pool.maxpoolsize"));
		securitydatasource.setMaxIdleTime(getIntProperty("connection.pool.maxidletime"));
		
		return securitydatasource;
	}
	
	private int getIntProperty(String prop) {
		String sp=env.getProperty(prop);
		int intprop = Integer.parseInt(sp);
		return intprop;
	}
	
}
