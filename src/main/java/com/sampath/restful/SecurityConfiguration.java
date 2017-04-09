package com.sampath.restful;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
    	// not a good idea
    	httpSecurity.headers().disable();
    	httpSecurity.csrf().disable();
        httpSecurity.authorizeRequests().antMatchers("/").permitAll();
    }
    
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) { 
        try {
			auth.inMemoryAuthentication()
			        .withUser("user").password("password").roles("USER").and()
			        .withUser("admin").password("password").roles("USER", "ADMIN");
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

}
