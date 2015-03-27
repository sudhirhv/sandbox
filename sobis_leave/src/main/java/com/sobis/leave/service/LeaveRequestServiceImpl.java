package com.sobis.leave.service;

import java.util.Date;
import java.util.List;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sobis.leave.dao.EmployeeDao;
import com.sobis.leave.dao.HolidayDao;
import com.sobis.leave.dao.LeaveRequestDao;
import com.sobis.leave.dao.LeaveStatusDao;
import com.sobis.leave.model.Employee;
import com.sobis.leave.model.LeaveRequest;
import com.sobis.leave.model.LeaveStatus;

@Service
@EnableTransactionManagement // we need to mention this for using @transactions
public class LeaveRequestServiceImpl implements LeaveRequestService {

	
	@Autowired
	private EmployeeDao employeeDao;
	
	@Autowired
	private LeaveStatusDao leaveStatusDao;
	
	@Autowired
	private HolidayDao holidayDao;
	
	@Autowired
	private LeaveRequestDao leaveRequestDao;
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)	
	public void createLeaveRequest(LeaveRequest leaveRequest) {
		DateTime createdDate = new DateTime();
		leaveRequest.setCreatedOn(createdDate);
		leaveRequest.setModifiedOn(createdDate);
		leaveRequestDao.createLeaveRequest(leaveRequest);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void processLeaveRequest(LeaveRequest leaveRequest) {
		leaveRequestDao.processLeaveRequestStatus(leaveRequest.getId(), leaveRequest.getLeaveStatus().getId());
	}

	@Override
	@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
	public List<LeaveRequest> getAllLeaveRequests() {
		return leaveRequestDao.getAllLeaveRequests();
	}

	@Override
	@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
	public LeaveRequest getLeaveRequestById(String leaveRequestId) {
		return leaveRequestDao.getLeaveRequestById(leaveRequestId);
	}

	@Override
	@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
	public int calculateLeaveDuration(DateTime startDate, DateTime endDate) {
		return leaveRequestDao.calculateLeaveDuration(startDate, endDate);
	}


}
