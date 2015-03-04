package com.sobis.leave.service;

import com.sobis.leave.model.EmployeeLeaveMaster;

public interface EmployeeLeaveMasterService {
	
	public int getAvailableLeaveBalance(String employeeId, int leaveYear);
	
	public void addEmployeeLeaveMasterService(EmployeeLeaveMaster employeeLeaveMaster);
}
