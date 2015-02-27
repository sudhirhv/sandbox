package com.sobis.leave.dao.jpaimpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.sobis.leave.dao.LeaveStatusDao;
import com.sobis.leave.model.LeaveStatus;

@Repository
public class LeaveStatusJpaImpl implements LeaveStatusDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public LeaveStatus getLeaveStatusById(int leaveStatusId) {
		return entityManager.find(LeaveStatus.class, leaveStatusId);	
	}

}
