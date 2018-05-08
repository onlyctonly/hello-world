package com.bashfan.config;

import java.beans.PropertyVetoException;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@ComponentScan(basePackages="com.bashfan")
public class SpringConfig {
	
	@Bean
	public DataSource datasource() {
		ComboPooledDataSource ds = new ComboPooledDataSource();
		try {
			ds.setDriverClass("com.mysql.cj.jdbc.Driver");
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
		ds.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/spring_db?useSSL=false");
		ds.setUser("root");
		ds.setPassword("root");
		ds.setInitialPoolSize(5);
		ds.setMinPoolSize(5);
		ds.setMaxPoolSize(20);
		ds.setMaxIdleTime(3000);
		return ds;
		
	}
	
}
