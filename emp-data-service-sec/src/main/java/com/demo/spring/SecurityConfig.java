package com.demo.spring;

 import javax.activation.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		 http.authorizeRequests().antMatchers("/info").permitAll().antMatchers("/emp/**").
		 hasAnyRole("USER","ADMIN").and().httpBasic().and().csrf().disable();
	}
	
	@Autowired
	javax.sql.DataSource ds;
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		/*auth.inMemoryAuthentication().withUser("jagadeesh").
		password("$2a$10$sXhZAeFWzIS8.mPTRrGwYejkhsuIrg/IhOcBNMPwvKP2yoqNA1z1G").roles("USER");
		auth.inMemoryAuthentication().withUser("sarani").
		password("$2a$10$sXhZAeFWzIS8.mPTRrGwYejkhsuIrg/IhOcBNMPwvKP2yoqNA1z1G").roles("ADMIN");
		auth.inMemoryAuthentication().withUser("sriram").
		password("$2a$10$sXhZAeFWzIS8.mPTRrGwYejkhsuIrg/IhOcBNMPwvKP2yoqNA1z1G").roles("PRODUCT");*/
		auth.jdbcAuthentication().dataSource(ds)
		.usersByUsernameQuery("select username,password,enabled from users where username=?")
		.authoritiesByUsernameQuery("select username,authority from authorities where username=?")
		;
	}
	
	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
}
