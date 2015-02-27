package com.sobis.leave.dao.jpaimpl;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.sobis.leave.dao.LeaveRequestDao;
import com.sobis.leave.model.Employee;
import com.sobis.leave.model.LeaveRequest;
import com.sobis.leave.model.LeaveStatus;

@Repository
public class LeaveRequestDaoJpaImpl implements LeaveRequestDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void createLeaveRequest(LeaveRequest leaveRequest) {
		entityManager.persist(leaveRequest);
	}

	@Override
	public LeaveRequest getLeaveRequestById(int leaveRequestId) {
		LeaveRequest leaveRequest = entityManager.find(LeaveRequest.class, leaveRequestId);
		return null;
	}	

	@Override
	public void processLeaveRequestStatus(int leaveRequestId, int leaveStatusId) {
		LeaveStatus leaveStatus = entityManager.find(LeaveStatus.class, leaveStatusId); //TODO	
		LeaveRequest leaveRequest = this.getLeaveRequestById(leaveRequestId);
		leaveRequest.setLeaveStatus(leaveStatus);
		entityManager.merge(leaveRequest);		
	}
	
	@Override
	public LeaveRequest getLeaveRequestForEmployee(int employeeId) {
		Query query = entityManager.createQuery("select lr from LeaveRequest lr where requestorId= :requestor", LeaveRequest.class);
		query.setParameter("requestor", employeeId);
		return (LeaveRequest) query.getResultList();
	}

	@Override
	public List<LeaveRequest> getAllLeaveRequests() {
		TypedQuery<LeaveRequest> query = entityManager.createQuery("select lr from LeaveRequest e", LeaveRequest.class);		
		return query.getResultList();
	}

	@Override
	public int calculateLeaveDuration(Date startDate, Date endDate) {		
		return 2; //TODO
	}

	@Override
	public void sendMailNotification(int leaveRequestId, int employeeId) {		
		System.out.println("mail successfully sent to "+employeeId);

	}



}
