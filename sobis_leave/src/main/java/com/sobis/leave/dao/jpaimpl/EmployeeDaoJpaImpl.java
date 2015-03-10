package com.sobis.leave.dao.jpaimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.sobis.leave.dao.EmployeeDao;
import com.sobis.leave.model.Employee;
import com.sobis.leave.model.EmployeeLeaveMaster;
@Repository
public class EmployeeDaoJpaImpl implements EmployeeDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void addEmployee(Employee employee) {
		entityManager.persist(employee);
	}

	@Override
	public Employee getEmployee(String id) {
		return entityManager.find(Employee.class, id);		
	}

	@Override
	public List<Employee> getAllEmployees() {
		TypedQuery<Employee> query = entityManager.createQuery("select e from Employee e", Employee.class);		
		return query.getResultList();
	}

	@Override
	public EmployeeLeaveMaster getEmployeeLeaveMaster(String employeeId, int leaveYear) {
		String jql = "select elm from EmployeeLeaveMaster elm where fk_employee= :employee and leaveYear = :leaveYear";
		Query query = entityManager.createQuery(jql);
		query.setParameter("employee", employeeId);
		query.setParameter("leaveYear", leaveYear);
		return (EmployeeLeaveMaster) query.getResultList().get(0);
	}

}
