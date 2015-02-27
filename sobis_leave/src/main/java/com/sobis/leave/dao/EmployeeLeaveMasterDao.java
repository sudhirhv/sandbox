package com.sobis.leave.dao;

import java.util.List;

import com.sobis.leave.model.EmployeeLeaveMaster;

public interface EmployeeLeaveMasterDao {
	
	public void addEmployeeLeaveMaster(EmployeeLeaveMaster employeeLeaveMaster);		
	
	public List<EmployeeLeaveMaster> getAllEmployeeLeaveMasters();		
	
}
