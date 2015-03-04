package com.sobis.leave.service;

import java.util.Date;
import java.util.List;

import com.sobis.leave.model.Employee;
import com.sobis.leave.model.LeaveRequest;
import com.sobis.leave.model.LeaveStatus;

public interface LeaveRequestService {

	public void createLeaveRequest(LeaveRequest leaveRequest);
	
	public void processLeaveRequest(LeaveRequest leaveRequest);
	
	public List<LeaveRequest> getAllLeaveRequests();
	
	public LeaveRequest getLeaveRequestById(String leaveRequestId);
	
	public int calculateLeaveDuration(Date startDate, Date endDate);
	
	
}
