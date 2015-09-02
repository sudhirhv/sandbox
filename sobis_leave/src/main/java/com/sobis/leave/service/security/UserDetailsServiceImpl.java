package com.sobis.leave.service.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sobis.leave.dao.security.UserDao;
import com.sobis.leave.model.security.Role;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserDao userDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {		
		
		com.sobis.leave.model.security.User user =  userDao.getUser(username);
		 
        return new org.springframework.security.core.userdetails.User(
        		user.getUsername(),
        		user.getPassword(),
                getAuthorities(user.getRoles())
        );		
        
	} 
	
	/*public Collection<? extends GrantedAuthority> getAuthorities(Integer role) {
        List<GrantedAuthority> authList = getGrantedAuthorities(getRoles(role));*/
    public Collection<? extends GrantedAuthority> getAuthorities(Set<Role> userRoles) {
    	List<String> roles = new ArrayList<String>();    	
    	for (Role role : userRoles) {    		
            roles.add(role.getRole());       
		}
        List<GrantedAuthority> authList = getGrantedAuthorities(roles);
        return authList;
    }
	
   public List<String> getRoles(Integer role) {
	   
        List<String> roles = new ArrayList<String>(); 
        if (role.intValue() == 1) {
            roles.add("ROLE_USER");           
        } else if (role.intValue() == 2) {
        	 roles.add("ROLE_ADMIN");
        }
        return roles;
    }
	
   
   public static List<GrantedAuthority> getGrantedAuthorities(List<String> roles) {
       List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        
       for (String role : roles) {
           authorities.add(new SimpleGrantedAuthority(role));
       }
       return authorities;
   }
}
