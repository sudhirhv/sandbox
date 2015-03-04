package com.sobis.leave.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sobis.leave.dao.EmployeeDao;
import com.sobis.leave.dao.EmployeeLeaveMasterDao;
import com.sobis.leave.dao.HolidayDao;
import com.sobis.leave.model.Employee;
import com.sobis.leave.model.EmployeeLeaveMaster;
import com.sobis.leave.model.Holiday;

@Service
@EnableTransactionManagement // we need to mention this for using @transactions
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;
	
	@Autowired
	private EmployeeLeaveMasterDao employeeLeaveMasterDao;
	
	@Autowired
	private HolidayDao holidayDao;
		
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void addEmployee(Employee employee) {
		Date createdDate = new Date();
		employee.setCreatedOn(createdDate);
		employee.setModifiedOn(createdDate);
		employeeDao.addEmployee(employee);		
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void addHoliday(Holiday holiday) {
		Date createdDate = new Date();
		holiday.setCreatedOn(createdDate);		
		holiday.setModifiedOn(createdDate);
		holidayDao.addHoliday(holiday);		
	}
	
	@Override
	@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
	public List<Employee> getAllEmployees() {
		return employeeDao.getAllEmployees();		
	}

	
	

	@Override
	@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
	public EmployeeLeaveMaster getEmployeeLeaveMaster(Employee employee, int leaveYear) {
		return employeeDao.getEmployeeLeaveMaster(employee.getId(), leaveYear);		
	}

	@Override
	@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
	public Employee getApprover(String employeeId) {
		return employeeDao.getEmployee(employeeId);
		
	}

	
}
