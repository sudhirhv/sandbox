package com.sobis.leave.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

import com.sobis.leave.dao.UserContextDao;
import com.sobis.leave.dao.security.UserDao;
import com.sobis.leave.model.security.User;

@Repository
public class SpringSecurityUserContext implements UserContextDao {

	@Override
	public User getCurrentUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCurrentUser(User user) {
		// TODO Auto-generated method stub
		
	}

/*	@PersistenceContext
	private EntityManager entityManager;
	
	private UserDetailsServiceImpl userDetailsService;
	
	@Override
	public User getCurrentUser() {
		SecurityContext context = SecurityContextHolder.getContext(); 
		Authentication authentication = context.getAuthentication();
		if (authentication == null) {
			return null;
		}
		return (User) authentication;
		
		String email = authentication.getName();
		return userDetailsService.findUserByEmail(email);
	}

	@Override
	public void setCurrentUser(User user) {
		throw new UnsupportedOperationException();
	}
*/
}
