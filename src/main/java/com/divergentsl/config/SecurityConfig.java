package com.divergentsl.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		
		// for insert username & password
		
//		http.csrf().disable();
//		http.authorizeRequests().mvcMatchers("/create")
//		.permitAll()
//		.anyRequest()
//		.authenticated();
		
		// for access using username & password
		
		http.authorizeRequests()
		.antMatchers("/home").hasAuthority("read")
		.and()
		.httpBasic();
	}
	
	
	@Bean
	public UserDetailsManager userDetailsService() {
		return new JdbcUserDetailsManager(dataSource());
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	@Bean
	public DataSource dataSource() {
		return new DriverManagerDataSource("jdbc:mysql://localhost:3306/springsecurity", "root", "root");
	}
	
}
