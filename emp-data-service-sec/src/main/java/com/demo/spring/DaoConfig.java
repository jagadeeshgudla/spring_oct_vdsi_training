package com.demo.spring;

import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//@Configuration
//@ComponentScan(basePackages = "com.demo.spring")
//@EnableTransactionManagement
//@EnableJpaRepositories(basePackages = "com.demo.spring.repo")
public class DaoConfig {

	@Bean("ds")
	public DriverManagerDataSource dataSource() {
		DriverManagerDataSource dmds = new DriverManagerDataSource();
		dmds.setDriverClassName("com.mysql.jdbc.Driver");
		dmds.setUrl("jdbc:mysql://localhost:3306/springdb?userSSL=false");
		dmds.setUsername("root");
		dmds.setPassword("root");
		return dmds;
	}

	/*
	 * @Bean public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
	 * LocalContainerEntityManagerFactoryBean emfb= new
	 * LocalContainerEntityManagerFactoryBean(); emfb.setDataSource(dataSource());
	 * emfb.setPackagesToScan("com.demo.spring.entity");
	 * 
	 * HibernateJpaVendorAdapter va= new HibernateJpaVendorAdapter();
	 * va.setDatabase(Database.MYSQL); va.setShowSql(true);
	 * emfb.setJpaVendorAdapter(va); return emfb; }
	 * 
	 * @Bean public JpaTransactionManager transactionManager(EntityManagerFactory
	 * emf) { JpaTransactionManager txm= new JpaTransactionManager();
	 * txm.setEntityManagerFactory(emf); return txm; }
	 */
}
