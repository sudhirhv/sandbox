package com.sobis.leave.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="leaveStatus")
public class LeaveStatus extends Base {

	@Column(name="statusValue")
	private String statusValue;
	
	public String getStatusValue() {
		return statusValue;
	}

	public void setStatusValue(String statusValue) {
		this.statusValue = statusValue;
	}

	public LeaveStatus() {
		
	}

	public LeaveStatus(String statusValue) {
		super();		
		this.statusValue = statusValue;
	}
	
	
	
}
