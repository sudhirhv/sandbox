package com.sobis.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sobis.dao.BugDao;
import com.sobis.dao.EmployeeDao;
import com.sobis.dao.ProjectDao;
import com.sobis.model.Bug;
import com.sobis.model.Employee;
import com.sobis.model.Project;

@Service
@EnableTransactionManagement // we need to mention this for using @transactions
public class BugTrackerServiceImpl implements BugTrackerService {

	@Autowired
	private EmployeeDao employeeDao;
	
	@Autowired
	private ProjectDao projectDao;
	
	@Autowired
	private BugDao bugDao;
	
	//@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.READ_COMMITTED)
	@Transactional(propagation=Propagation.REQUIRED)
	@Override	
	public void insertEmployee(Employee employee) {
		employeeDao.addEmployee(employee);
	}

	@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
	@Override	
	public List<Employee> fetchAllEmployees() {
		return employeeDao.getEmployees();		
	}

	//user SUPPORTS for fetching and reading
	@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
	@Override	
	public List<Project> fetchAllProjects() {
		return projectDao.getProjects();
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public void reportBug(Bug bug) {
		Project p = projectDao.getProject(bug.getProject().getProjectId());
		Employee e = employeeDao.getEmployee(bug.getRaisedBy().getId());
		bug.setRaisedBy(e);
		bug.setProject(p);
		bugDao.raiseBug(bug);
	}

	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public void resolveBug(Bug bug) {
		Bug b = bugDao.getById(bug.getBugId());
		Employee e = employeeDao.getEmployee(bug.getResolvedBy().getId());
		b.setResolvedBy(e);
		b.setResolvedDate(new Date());	    
		bugDao.resolveBug(b);
	}

	@Transactional(propagation=Propagation.SUPPORTS)
	@Override
	public List<Bug> getAllBugs() {
		return bugDao.getAllBugs();
	}
	
	

}
