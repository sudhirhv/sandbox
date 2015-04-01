package com.sobis.leave.dao.jpaimpl;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sobis.leave.dao.HolidayDao;
import com.sobis.leave.dao.LeaveRequestDao;
import com.sobis.leave.model.Employee;
import com.sobis.leave.model.Holiday;
import com.sobis.leave.model.LeaveRequest;
import com.sobis.leave.model.LeaveStatus;

@Repository
public class LeaveRequestDaoJpaImpl implements LeaveRequestDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private HolidayDao holidayDao;

	@Override
	public void createLeaveRequest(LeaveRequest leaveRequest) {
		entityManager.persist(leaveRequest);
	}

	@Override
	public LeaveRequest getLeaveRequestById(String leaveRequestId) {
		LeaveRequest leaveRequest = entityManager.find(LeaveRequest.class, leaveRequestId);
		return null;
	}	

	@Override
	public void processLeaveRequestStatus(String leaveRequestId, String leaveStatusId) {
		LeaveStatus leaveStatus = entityManager.find(LeaveStatus.class, leaveStatusId); //TODO	
		LeaveRequest leaveRequest = this.getLeaveRequestById(leaveRequestId);
		leaveRequest.setLeaveStatus(leaveStatus);
		entityManager.merge(leaveRequest);		
	}
	
	@Override
	public LeaveRequest getLeaveRequestForEmployee(String employeeId) {
		Query query = entityManager.createQuery("select lr from LeaveRequest lr where requestorId= :requestor", LeaveRequest.class);
		query.setParameter("requestor", employeeId);
		return (LeaveRequest) query.getResultList();
	}

	@Override
	public List<LeaveRequest> getAllLeaveRequests() {
		TypedQuery<LeaveRequest> query = entityManager.createQuery("select lr from LeaveRequest lr", LeaveRequest.class);		
		return query.getResultList();
	}

	@Override
	public int calculateLeaveDuration(DateTime startDate, DateTime endDate) {
		LocalDate dateStart = new LocalDate(startDate);
		LocalDate dateEnd = new LocalDate(endDate);
		List<Holiday> listOfHolidays = holidayDao.getAllHolidays();
		int count = 0;
		Query q = entityManager.createQuery("select h.holidayDate from Holiday h", Holiday.class);
	    List<Object[]> holidays= q.getResultList();
	   
	    /*for(Object[] holiday: holidays){	         
	    	(Integer)employee[0];
	    }*/
		
		
		// day by day:
		while(dateStart.isBefore(dateEnd)){
			System.out.println(dateStart);
			if(holidays.contains(dateStart)) {
				count++;
			}
		    dateStart = dateStart.plusDays(1);		
		}
		return count;
	}

	@Override
	public void sendMailNotification(String leaveRequestId, String employeeId) {		
		System.out.println("mail successfully sent to "+employeeId);

	}



}
