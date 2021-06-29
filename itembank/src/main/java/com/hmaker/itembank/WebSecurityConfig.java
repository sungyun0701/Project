package com.hmaker.itembank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	CustomAuthenticationProvider customAuthenticationProvider;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(customAuthenticationProvider);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/","/user/**").permitAll()
				.antMatchers("/webjars/**", "/css/**", "/webfonts/**","/js/**", "/images/**").permitAll()
				.antMatchers("/admin/**").hasAuthority("ROLE_ADMIN")
//				.antMatchers("/db/**").access("hasRole('ADMIN') and hasRole('DBA')") 
				.anyRequest().authenticated()
//				.antMatchers("/admin/**").access(hasRole("ROLE_ADMIN"))
				
//			.antMatchers("/user/logout").authenticated()
//			.antMatchers("/admin/**").hasRole("RONE_ADMIN")
//			.anyRequest().permitAll();
				.and()
			.formLogin()
				.loginPage("/user/login").permitAll()
				.defaultSuccessUrl("/")
				.and()
			.logout()
				.logoutUrl("/user/logout_result")
				.logoutSuccessUrl("/user/logout_result");
	}

}
