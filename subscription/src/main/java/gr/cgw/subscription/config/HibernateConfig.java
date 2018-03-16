package gr.cgw.subscription.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@PropertySource(value= {"classpath:hibernate.properties"})
public class HibernateConfig {

	@Autowired
	private Environment env;
	
	@Autowired
	private DataSource securitydatasource;
	
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(securitydatasource);
		sessionFactory.setPackagesToScan("gr.cgw.subscription.model");
		sessionFactory.setHibernateProperties(hibernateProperties());
		return sessionFactory; 
	}
	
//	@Bean
//	public DataSource dataSource() {
//		DriverManagerDataSource dataSource = new DriverManagerDataSource();
//		dataSource.setDriverClassName(env.getProperty("jdbc.driver"));
//		dataSource.setUrl(env.getProperty("jdbc.url"));
//		dataSource.setUsername(env.getProperty("jdbc.username"));
//		dataSource.setPassword(env.getProperty("jdbc.password"));
//		return dataSource;
//	}
	
	@Bean
	public Properties hibernateProperties() {
		Properties hibernateProperties = new Properties();
		hibernateProperties.put("hibernate.dialect", env.getRequiredProperty("hibernate.dialect"));
		hibernateProperties.put("hibernate.show_sql", env.getRequiredProperty("hibernate.show_sql"));
		hibernateProperties.put("hibernate.format_sql", env.getRequiredProperty("hibernate.format_sql"));
		hibernateProperties.put("hibernate.hbm2ddl.auto", env.getRequiredProperty("hibernate.hbm2ddl.auto"));
		return hibernateProperties;
	}
	
	@Bean
	@Autowired
	public HibernateTransactionManager htm(SessionFactory s) {
		HibernateTransactionManager htm = new HibernateTransactionManager();
		htm.setSessionFactory(s);
		return htm;
	}
	
}
