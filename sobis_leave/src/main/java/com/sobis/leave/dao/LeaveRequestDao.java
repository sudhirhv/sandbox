package com.sobis.leave.dao;

import java.util.Date;
import java.util.List;

import com.sobis.leave.model.LeaveRequest;

public interface LeaveRequestDao {

	public void createLeaveRequest(LeaveRequest leaveRequest);
	
	public LeaveRequest getLeaveRequestById(String leaveRequestId);
	
	public void processLeaveRequestStatus(String leaveRequestId, String leaveStatusId);
	
	public LeaveRequest getLeaveRequestForEmployee(String employeeId);
	
	public List<LeaveRequest> getAllLeaveRequests();
		
	public int calculateLeaveDuration(Date startDate, Date endDate);
	
	public void sendMailNotification(String leaveRequestId, String employeeId);
	
}
