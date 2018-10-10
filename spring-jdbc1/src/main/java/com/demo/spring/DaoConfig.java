package com.demo.spring;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages="com.demo.spring")
@EnableTransactionManagement
public class DaoConfig {

	@Bean
	@Qualifier(value="ds")
	public DriverManagerDataSource dataSource() {
		DriverManagerDataSource dmds= new DriverManagerDataSource();
		dmds.setDriverClassName("com.mysql.jdbc.Driver");
		dmds.setUrl("jdbc:mysql://localhost:3306/springdb?userSSL=false");
		dmds.setUsername("root");
		dmds.setPassword("root"); 
		return dmds;
	}
	
	
	
	@Bean
	public DriverManagerDataSource dataSource1() {
		DriverManagerDataSource dmds= new DriverManagerDataSource();
		dmds.setDriverClassName("com.mysql.jdbc.Driver");
		dmds.setUrl("jdbc:mysql://localhost:3306/springdb?userSSL=false");
		dmds.setUsername("root");
		dmds.setPassword("root"); 
		return dmds;
	}
	
	
	@Bean
	public JdbcTemplate jt( javax.sql.DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}
	
	
	
	
	
	
	@Bean
	public DataSourceTransactionManager transactionManager(@Qualifier("ds")javax.sql.DataSource ds) {
		DataSourceTransactionManager dtx= new DataSourceTransactionManager(ds);
		return dtx;
	}
	
	
	
	
	
	
	
	
}
