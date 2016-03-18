package com.sobis.carparking.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="attendance")
public class Attendance extends Base {

	@Column(name="date")
	private Date date;
		
	@OneToOne()
	@JoinColumn(name="fk_employee")	
	private Employee employee;

	public Attendance() {
		
	}	
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	
	
}
