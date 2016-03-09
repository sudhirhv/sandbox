package com.sobis.carparking.dao.jpaimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.sobis.carparking.dao.UserDao;
import com.sobis.carparking.model.User;
@Repository
public class UserDaoJpaImpl implements UserDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void addUser(User user) {
		entityManager.persist(user);
	}

	@Override
	public List<User> getAllUsers() {
		TypedQuery<User> query = entityManager.createQuery("from User", User.class);		
		return query.getResultList();
	}

	@Override
	public User getUserById(String userId) {
		TypedQuery<User> query = entityManager.createQuery("select u from User u where u.id=:userId ", User.class);		
		query.setParameter("userId",userId);
		return (User) query.getResultList();
	}

	@Override
	public User getUserByUserName(String userName) {		
		TypedQuery<User> query = entityManager.createQuery("select u from User u where u.userName=:userName ", User.class);	
		query.setParameter("userName",userName);		
		List<User> users = query.getResultList();
		User user = null;
	    for (int i = 0; i < users.size(); i++){
	        user = (User) users.get(i);
	    }
		return user;
	}

}
