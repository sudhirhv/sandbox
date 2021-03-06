package com.sobis.carparking.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	@Qualifier("userDetailsService")
	UserDetailsService userDetailsService;
	
	@Autowired
	@Qualifier("customSuccessHandler")
    SimpleUrlAuthenticationSuccessHandler customSuccessHandler;
	
	@Autowired
	@Qualifier("customFailureHandler")
    SimpleUrlAuthenticationFailureHandler customFailureHandler;
	
	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
        	.passwordEncoder(passwordEncoder());
    }

	
	public PasswordEncoder passwordEncoder(){
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.inMemoryAuthentication()
				.withUser("sudhir").password("$2a$08$6tldOLp1bS.LhE53po3.CeThghz5r5uEeeSlno.IJBOOYepy394C.").roles("USER");				
	}
	
	/*protected void configure(HttpSecurity http) throws Exception {
	    http
	        .authorizeRequests()
	            .anyRequest().authenticated() 
	            .and()
	        .formLogin()                      
	            .and()
	        .httpBasic()
	        	.and()
	        .csrf().disable();                     
	}*/

	
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()	
				.antMatchers("/resources/**").permitAll()		
				.antMatchers("/carparking/index.html").access("hasRole('ROLE_USER')")
				.antMatchers("/carparking/**").permitAll()
				.antMatchers("/carparking/.sencha/**", "/carparking/app/**", "/carparking/resources/**",
						"/carparking/unprotected/**", "/carparking/touch/**").permitAll()
				.antMatchers("/carparking/app.js", "/carparking/app.json",
						"/carparking/bootstrap.json", "/carparking/bootstrap.js",
						"/carparking/cache.manifest").permitAll()
				
				.anyRequest().authenticated()
				.and()				
			.formLogin().loginPage("/login")
				.successHandler(customSuccessHandler)
				.failureHandler(customFailureHandler)//.defaultSuccessUrl("/carparking/index.html")								
				.loginProcessingUrl("/j_spring_security_check")				
				.permitAll()				
				.and()			
			.logout().permitAll().and()
			.csrf().disable();			
	}
	
}
