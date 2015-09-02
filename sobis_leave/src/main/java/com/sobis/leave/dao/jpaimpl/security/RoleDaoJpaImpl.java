package com.sobis.leave.dao.jpaimpl.security;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.sobis.leave.dao.security.RoleDao;
import com.sobis.leave.model.Employee;
import com.sobis.leave.model.security.Role;
@Repository
public class RoleDaoJpaImpl implements RoleDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Role getRole(String roleId) {
		return entityManager.find(Role.class, roleId);		
	}

	@Override
	public void createRole(Role role) {
		entityManager.persist(role);
	}
	
}
