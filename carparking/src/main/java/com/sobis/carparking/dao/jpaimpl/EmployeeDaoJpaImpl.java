package com.sobis.carparking.dao.jpaimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sobis.carparking.dao.EmployeeDao;
import com.sobis.carparking.dao.UserDao;
import com.sobis.carparking.model.Employee;
import com.sobis.carparking.model.File;
import com.sobis.carparking.model.User;

@Repository
public class EmployeeDaoJpaImpl implements EmployeeDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private UserDao userDao;
	
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

	@Override
	public Employee getEmployeeByUserName(String userName) {
		User user = userDao.getUserByUserName(userName);
		System.out.println("userobj "+user.getPassword());
		TypedQuery<Employee> query = entityManager.createQuery("select e from Employee e where e.user.id=:userId", Employee.class);
		query.setParameter("userId",user.getId());	
		System.out.println("in employee query");
		List<Employee> employees = query.getResultList();
		Employee employee = null;
	    for (int i = 0; i < employees.size(); i++){
	    	employee = (Employee) employees.get(i);
	    }
		return employee;
		
	}

}
