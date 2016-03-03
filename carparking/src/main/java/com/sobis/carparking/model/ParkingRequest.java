package com.sobis.carparking.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="parkingRequests")
public class ParkingRequest extends Base {
	
	@OneToOne()
	@JoinColumn(name="fk_employee")		
	private Employee employee;
	
	
	@OneToOne()
	@JoinColumn(name="fk_parkingSlot")	
	private ParkingSlot parkingSlot;
	
	
	@Column(name="parkingDate")	
	private Date parkingDate;
	
	public ParkingRequest(){
		
	}
	//@JsonSerialize(using = ParkingRequestSerializer.class)
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public ParkingSlot getParkingSlot() {
		return parkingSlot;
	}
	public void setParkingSlot(ParkingSlot parkingSlot) {
		this.parkingSlot = parkingSlot;
	}
	public Date getParkingDate() {
		return parkingDate;
	}
	public void setParkingDate(Date parkingDate) {
		this.parkingDate = parkingDate;
	}	
	
}
