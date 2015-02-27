package com.sobis.leave.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="leaveStatus")
public class LeaveStatus implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	@Column(name="leaveStatusId")
	private int leaveStatusId;
	

	@Column(name="statusValue")
	private String statusValue;
	
	public int getLeaveStatusId() {
		return leaveStatusId;
	}

	public void setLeaveStatusId(int leaveStatusId) {
		this.leaveStatusId = leaveStatusId;
	}

	public String getStatusValue() {
		return statusValue;
	}

	public void setStatusValue(String statusValue) {
		this.statusValue = statusValue;
	}

	public LeaveStatus() {
		
	}

	public LeaveStatus(int leaveStatusId, String statusValue) {
		super();
		this.leaveStatusId = leaveStatusId;
		this.statusValue = statusValue;
	}
	
	
	
}
