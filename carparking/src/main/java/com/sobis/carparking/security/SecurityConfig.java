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


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	@Qualifier("userDetailsService")
	UserDetailsService userDetailsService;
	
	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
        	.passwordEncoder(passwordEncoder());
    }

	
	public PasswordEncoder passwordEncoder(){
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}
    
	/*@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.inMemoryAuthentication()
				.withUser("sudhir").password("$2a$08$6tldOLp1bS.LhE53po3.CeThghz5r5uEeeSlno.IJBOOYepy394C.").roles("USER");				
	}
	
	protected void configure(HttpSecurity http) throws Exception {
	    http
	        .authorizeRequests()
	            .anyRequest().authenticated() 
	            .and()
	        .formLogin()                      
	            .and()
	        .httpBasic()
	        	.and()
	        .csrf().disable();                     
	}
*/
	
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()		
				.antMatchers("/resources/**").permitAll()
				.antMatchers("/carparking/resources/**").permitAll()
				.antMatchers("/carparking/touch/**").permitAll()
				.anyRequest().authenticated()
				.and()				
			.formLogin().loginPage("/login").defaultSuccessUrl("/carparking/index.html")
				.loginProcessingUrl("/j_spring_security_check")
				.permitAll()
				.and()			
			.csrf().disable();			
	}
	
}