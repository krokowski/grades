package com.grades.config;

import com.grades.security.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Created by Wojciech.Krokowski on 2017-01-08.
 */
@Configuration
@EnableWebSecurity
@ComponentScan(basePackageClasses = CustomUserDetailsService.class)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordencoder());
	}

	@Override
    protected void configure(HttpSecurity http) throws Exception {
    	http
    		.formLogin()
	    		.loginPage("/login")
	            .usernameParameter("email").passwordParameter("password")
	            .and()
	            .logout().logoutSuccessUrl("/login?logout")
	            .and()
	            .exceptionHandling().accessDeniedPage("/403")
	            .and()
	         .authorizeRequests()
                .antMatchers("/home").authenticated()
                .antMatchers("/user/**").access("hasRole('ROLE_ADMIN')")
                .antMatchers("/subject-block/**").access("hasRole('ROLE_WORKER')")
                .antMatchers("/student-subject/**").access("hasRole('ROLE_STUDENT')")
                .antMatchers("/grades/**").access("hasRole('ROLE_STUDENT')")
                .antMatchers("/grade/add/**").access("hasRole('ROLE_WORKER')")
                .anyRequest().permitAll();
        http.csrf().disable();

    }

	@Bean(name = "passwordEncoder")
	public PasswordEncoder passwordencoder() {
		return new BCryptPasswordEncoder();
	}
}
