package com.sobis.leave.dao;

import java.util.List;

import com.sobis.leave.model.Employee;
import com.sobis.leave.model.EmployeeLeaveMaster;

public interface EmployeeDao {

	public void addEmployee(Employee employee);
	
	public Employee getEmployee(int id);
	
	public List<Employee> getAllEmployees();	
	
	public EmployeeLeaveMaster getEmployeeLeaveMaster(int employeeId, int leaveYear);
}
