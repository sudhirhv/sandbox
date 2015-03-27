package com.sobis.leave.dao;

import java.util.Date;
import java.util.List;

import org.joda.time.DateTime;

import com.sobis.leave.model.LeaveRequest;

public interface LeaveRequestDao {

	public void createLeaveRequest(LeaveRequest leaveRequest);
	
	public LeaveRequest getLeaveRequestById(String leaveRequestId);
	
	public void processLeaveRequestStatus(String leaveRequestId, String leaveStatusId);
	
	public LeaveRequest getLeaveRequestForEmployee(String employeeId);
	
	public List<LeaveRequest> getAllLeaveRequests();
		
	public int calculateLeaveDuration(DateTime startDate, DateTime endDate);
	
	public void sendMailNotification(String leaveRequestId, String employeeId);
	
}
