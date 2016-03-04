package com.sobis.carparking.dao.jpaimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.sobis.carparking.dao.RoleDao;
import com.sobis.carparking.model.ParkingSlot;
import com.sobis.carparking.model.Role;
import com.sobis.carparking.model.User;
@Repository
public class RoleDaoJpaImpl implements RoleDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void addRole(Role role) {
		entityManager.persist(role);
	}

	@Override
	public List<Role> getAllRoles() {
		TypedQuery<Role> query = entityManager.createQuery("from Role", Role.class);		
		return query.getResultList();
	}

	@Override
	public Role getRoleById(String roleId) {
		return entityManager.find(Role.class, roleId);	
	}

	@Override
	public List<User> getAllUsersForRole(Role role) {
		//TypedQuery<User> query = entityManager.createQuery("Select u from Role r where r.roleId=:roleId", Role.class);		
		//return query.getResultList();
		return null;
	}

}
