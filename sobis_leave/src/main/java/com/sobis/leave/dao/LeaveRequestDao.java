package com.sobis.leave.dao;

import java.util.Date;
import java.util.List;

import com.sobis.leave.model.LeaveRequest;

public interface LeaveRequestDao {

	public void createLeaveRequest(LeaveRequest leaveRequest);
	
	public LeaveRequest getLeaveRequestById(int leaveRequestId);
	
	public void processLeaveRequestStatus(int leaveRequestId, int leaveStatusId);
	
	public LeaveRequest getLeaveRequestForEmployee(int employeeId);
	
	public List<LeaveRequest> getAllLeaveRequests();
		
	public int calculateLeaveDuration(Date startDate, Date endDate);
	
	public void sendMailNotification(int leaveRequestId, int employeeId);
	
}
