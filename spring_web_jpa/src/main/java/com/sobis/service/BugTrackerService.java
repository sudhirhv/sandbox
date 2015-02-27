package com.sobis.service;

import java.util.List;

import com.sobis.model.Bug;
import com.sobis.model.Employee;
import com.sobis.model.Project;

public interface BugTrackerService {

	public void insertEmployee(Employee employee);
	
	public List<Employee> fetchAllEmployees();
	
	public List<Project> fetchAllProjects();
	
	public void reportBug(Bug bug);
	
	public void resolveBug(Bug bug);	
	
	public List<Bug> getAllBugs();	
	
	
}
