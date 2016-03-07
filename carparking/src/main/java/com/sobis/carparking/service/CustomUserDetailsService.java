package com.sobis.carparking.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sobis.carparking.dao.UserDao;
import com.sobis.carparking.model.Role;
import com.sobis.carparking.model.SecurityUser;
import com.sobis.carparking.model.User;

@Service("userDetailsService")
public class CustomUserDetailsService implements UserDetailsService
{
	@Autowired
	private UserDao userDao;
	
	@Override
	@Transactional(readOnly=true)	
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		System.out.println("username "+userName);
		User user = userDao.getUserByUserName((userName));
		if(user == null) throw new UsernameNotFoundException("UserName "+userName+" not found");		
		//return new SecurityUser(user);	
		
		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), true, true, true, true, getAuthorities(user));
	}
	
	
	public Collection<? extends GrantedAuthority> getAuthorities(User user) {
		Collection<GrantedAuthority> authorities = new ArrayList<>();
		Set<Role> userRoles = user.getRoles();
		
		if(userRoles != null)
		{
			for (Role role : userRoles) {
				SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role.getRoleName());
				authorities.add(authority);
			}
		}
		return authorities;
	}
}
