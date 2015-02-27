package com.sobis.dao;

import java.util.List;

import com.sobis.model.Employee;

public interface EmployeeDao {

	public void addEmployee(Employee employee);
	
	public Employee getEmployee(int id);
	
	public List<Employee> getEmployees();
}
