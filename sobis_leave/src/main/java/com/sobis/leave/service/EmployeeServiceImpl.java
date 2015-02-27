package com.sobis.leave.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sobis.leave.dao.EmployeeDao;
import com.sobis.leave.dao.EmployeeLeaveMasterDao;
import com.sobis.leave.model.Employee;
import com.sobis.leave.model.EmployeeLeaveMaster;

@Service
@EnableTransactionManagement // we need to mention this for using @transactions
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;
	
	@Autowired
	private EmployeeLeaveMasterDao employeeLeaveMasterDao;
		
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void addEmployee(Employee employee) {
		employeeDao.addEmployee(employee);		
	}
	
	@Override
	@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
	public List<Employee> getAllEmployees() {
		return employeeDao.getAllEmployees();		
	}

	@Override
	@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
	public int getAvailableLeaveBalance(int employeeId, int leaveYear) {
		return employeeDao.getEmployeeLeaveMaster(employeeId, leaveYear).getAvailableLeaveBalance();		
	}

	@Override
	@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
	public Employee getApprover(int employeeId) {
		return employeeDao.getEmployee(employeeId);
		
	}

	@Override
	@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
	public EmployeeLeaveMaster getEmployeeLeaveMaster(Employee employee, int leaveYear) {
		return employeeDao.getEmployeeLeaveMaster(employee.getId(), leaveYear);		
	}

}
