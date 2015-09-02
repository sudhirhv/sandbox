package com.sobis.leave.dao.jpaimpl.security;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.sobis.leave.dao.security.UserDao;
import com.sobis.leave.model.Employee;
import com.sobis.leave.model.EmployeeLeaveMaster;
import com.sobis.leave.model.security.User;
@Repository
public class UserDaoJpaImpl implements UserDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void createUser(User user) {
		entityManager.persist(user);
	}

	@Override
	public User getUser(String username) {
		String jql = "select user from User user where username= :username";
		Query query = entityManager.createQuery(jql);
		query.setParameter("username", username);		
		return (User) query.getResultList().get(0);
	}

	@Override
	public List<User> getAllUsers() {
		TypedQuery<User> query = entityManager.createQuery("select u from User u", User.class);		
		return query.getResultList();
	}

}
