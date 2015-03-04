package com.sobis.leave.dao.jpaimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.sobis.leave.dao.EmployeeLeaveMasterDao;
import com.sobis.leave.model.EmployeeLeaveMaster;
import com.sobis.leave.model.Holiday;
@Repository
public class EmployeeLeaveMasterJpaImpl implements EmployeeLeaveMasterDao {

	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void addEmployeeLeaveMaster(EmployeeLeaveMaster employeeLeaveMaster) {
		entityManager.persist(employeeLeaveMaster);		
	}
	
	@Override
	public List<EmployeeLeaveMaster> getAllEmployeeLeaveMasters() {
		TypedQuery<EmployeeLeaveMaster> query = entityManager.createQuery("select elm from EmployeeLeaveMaster elm", EmployeeLeaveMaster.class);		
		return query.getResultList();
	}

	@Override
	public int getAvailableLeaveBalance(String employeeId, int leaveYear) {
		String jql = "select elm from EmployeeLeaveMaster elm where fk_employee= :employee and leaveYear = :leaveYear";
		Query query = entityManager.createQuery(jql);
		query.setParameter("employee", employeeId);
		query.setParameter("leaveYear", leaveYear);
		EmployeeLeaveMaster employeeLeaveMaster = (EmployeeLeaveMaster) query.getResultList();
		return employeeLeaveMaster.getAvailableLeaveBalance();
	}

}
