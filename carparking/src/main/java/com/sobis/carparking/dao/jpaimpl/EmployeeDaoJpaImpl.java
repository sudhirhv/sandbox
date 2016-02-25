package com.sobis.carparking.dao.jpaimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.sobis.carparking.dao.EmployeeDao;
import com.sobis.carparking.model.Employee;
import com.sobis.carparking.model.File;

@Repository
public class EmployeeDaoJpaImpl implements EmployeeDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void addEmployee(Employee employee) {
		entityManager.persist(employee);
	}

	@Override
	public Employee getEmployee(String employeeId) {
		return entityManager.find(Employee.class, employeeId);	
	}

	@Override
	public List<Employee> getAllEmployees() {
		TypedQuery<Employee> query = entityManager.createQuery("select e from Employee e", Employee.class);		
		return query.getResultList();
	}

	@Override
	public File getImage(String employeeId) {
		// TODO Auto-generated method stub
		return null;
	}

}
