package com.sobis.carparking.model;

import java.util.Date;

import org.springframework.stereotype.Component;


@Component
public class ParkingSlotResult {
	private String ps_id;
	private String fk_employee;
	private Date parkingDate;	
	private String pr_id;
	private String employeeName;
	
	public String getPr_id() {
		return pr_id;
	}
	public void setPr_id(String pr_id) {
		this.pr_id = pr_id;
	}
	public String getPs_id() {
		return ps_id;
	}
	public ParkingSlotResult() {
		
	}
	public ParkingSlotResult(String ps_id, String fk_employee, Date parkingDate,String pr_id, String employeeName) {		
		this.ps_id = ps_id;
		this.fk_employee = fk_employee;
		this.parkingDate = parkingDate;		
		this.pr_id = pr_id;
		this.employeeName = employeeName;
	}
	public void setPs_id(String ps_id) {
		this.ps_id = ps_id;
	}
	public String getFk_employee() {
		return fk_employee;
	}
	public void setFk_employee(String fk_employee) {
		this.fk_employee = fk_employee;
	}
	public Date getParkingDate() {
		return parkingDate;
	}
	public void setParkingDate(Date parkingDate) {
		this.parkingDate = parkingDate;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
}
