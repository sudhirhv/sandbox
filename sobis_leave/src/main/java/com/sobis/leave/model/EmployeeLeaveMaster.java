package com.sobis.leave.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="employeeLeaveMaster")
public class EmployeeLeaveMaster extends Base {
	
	@ManyToOne
	@JoinColumn(name="fk_employee")
	private Employee employee;
	
	@Column(name="leaveYear")
	private int leaveYear;
	
	@Column(name="availableLeaveBalance")
	private int availableLeaveBalance;
	
	@Column(name="openingLeaveBalance")
	private int openingLeaveBalance;

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

	public EmployeeLeaveMaster(Employee employee,int leaveYear, int availableLeaveBalance, int openingLeaveBalance) {
		super();		
		this.employee = employee;		
		this.leaveYear = leaveYear;
		this.availableLeaveBalance = availableLeaveBalance;
		this.openingLeaveBalance = openingLeaveBalance;
	}
	
	public EmployeeLeaveMaster() {
		
	}
	
}
