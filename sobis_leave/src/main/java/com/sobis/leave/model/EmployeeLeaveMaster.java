package com.sobis.leave.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="employeeLeaveMaster")
public class EmployeeLeaveMaster implements Serializable {

	private static final long serialVersionUID = -8150501053574383839L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int employeeLeaveMasterId;
	
	@ManyToOne
	@JoinColumn(name="fk_employee")
	private Employee employee;
	
	@Column(name="leaveYear")
	private int leaveYear;
	
	@Column(name="availableLeaveBalance")
	private int availableLeaveBalance;
	
	@Column(name="openingLeaveBalance")
	private int openingLeaveBalance;

	public int getEmployeeLeaveMasterId() {
		return employeeLeaveMasterId;
	}

	public void setEmployeeLeaveMasterId(int employeeLeaveMasterId) {
		this.employeeLeaveMasterId = employeeLeaveMasterId;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public int getLeaveYear() {
		return leaveYear;
	}

	public void setLeaveYear(int leaveYear) {
		this.leaveYear = leaveYear;
	}

	public int getAvailableLeaveBalance() {
		return availableLeaveBalance;
	}

	public void setAvailableLeaveBalance(int availableLeaveBalance) {
		this.availableLeaveBalance = availableLeaveBalance;
	}

	public int getOpeningLeaveBalance() {
		return openingLeaveBalance;
	}

	public void setOpeningLeaveBalance(int openingLeaveBalance) {
		this.openingLeaveBalance = openingLeaveBalance;
	}

	public EmployeeLeaveMaster(int employeeLeaveMasterId, Employee employee,
			Employee approver, int leaveYear, int availableLeaveBalance,
			int openingLeaveBalance) {
		super();
		this.employeeLeaveMasterId = employeeLeaveMasterId;
		this.employee = employee;		
		this.leaveYear = leaveYear;
		this.availableLeaveBalance = availableLeaveBalance;
		this.openingLeaveBalance = openingLeaveBalance;
	}
	
	public EmployeeLeaveMaster() {
		
	}
	
}
