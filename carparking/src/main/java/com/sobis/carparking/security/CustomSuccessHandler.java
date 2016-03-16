package com.sobis.carparking.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class CustomSuccessHandler extends SimpleUrlAuthenticationSuccessHandler{
 
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
    
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
		handle(request, response, authentication);
		clearAuthenticationAttributes(request);
		
	}
    
    @Override
    protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
    	
        boolean userType = determineUserType(authentication);  
        if (response.isCommitted()) {
            System.out.println("Can't redirect");
            return;
        }        
        if(userType) {
        	response.setContentType("application/json");
    		String jsonResponse = "{'success':true}";
    		response.getWriter().print(jsonResponse);
    		response.getWriter().flush();
        } else {
        	redirectStrategy.sendRedirect(request, response, "carparking/login.html");
        }
    }
     
    protected boolean determineUserType(Authentication authentication) {
        String url="";         
        Collection<? extends GrantedAuthority> authorities =  authentication.getAuthorities();         
        List<String> roles = new ArrayList<String>(); 
        for (GrantedAuthority a : authorities) {
            roles.add(a.getAuthority());
        } 
        boolean userType = false;
        if (isAdmin(roles) || isUser(roles)) {
        	userType = true;
        }
        return userType;
    }
  
    public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
        this.redirectStrategy = redirectStrategy;
    }
    protected RedirectStrategy getRedirectStrategy() {
        return redirectStrategy;
    }
     
    private boolean isUser(List<String> roles) {
        if (roles.contains("ROLE_USER")) {
            return true;
        }
        return false;
    }
 
    private boolean isAdmin(List<String> roles) {
        if (roles.contains("ROLE_ADMIN")) {
            return true;
        }
        return false;
    } 
}