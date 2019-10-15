package com.monisoni.netbanking.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
@ComponentScan(basePackages = "com.monisoni.netbanking")
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

	// add a reference to our security data source

	@Autowired
	private DataSource securityDataSource;

	@Autowired
	@Qualifier("customUserDetailsService")
	private UserDetailsService userDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.userDetailsService(userDetailsService);
		auth.jdbcAuthentication().dataSource(securityDataSource);

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
			.antMatchers("/").hasRole("USER")
			.antMatchers("/leaders/**").hasRole("MANAGER")
			.antMatchers("/systems/**").hasRole("ADMIN")
			.and().formLogin().loginPage("/showMyLoginPage")
				.loginProcessingUrl("/authenticateTheUser").permitAll()
			.and().logout().permitAll().and()
				.exceptionHandling().accessDeniedPage("/access-denied");

	}

}
