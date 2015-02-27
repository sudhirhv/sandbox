package com.sobis.dao.jpaimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.sobis.dao.EmployeeDao;
import com.sobis.model.Employee;

@Repository
public class EmployeeDaoJpaImpl implements EmployeeDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void addEmployee(Employee employee) {
		entityManager.persist(employee);
	}

	@Override
	public Employee getEmployee(int id) {
		return entityManager.find(Employee.class, id);

	}

	@Override
	public List<Employee> getEmployees() {		
		TypedQuery<Employee> query = entityManager.createQuery("select e from Employee e", Employee.class);		
		return query.getResultList();
	}

}
