package com.sobis.leave.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name="leaveRequests")
public class LeaveRequest extends Base {

	@ManyToOne()
	@JoinColumn(name="fk_requestorName")
	private Employee requestorName;
	
	@ManyToOne()
	@JoinColumn(name="fk_approverName")
	private Employee approverName;
	
	
	@Column(name="leaveStartDate")
	@DateTimeFormat(iso=ISO.NONE)
	private Date leaveStartDate;
	
		
	@Column(name="leaveEndDate")
	@DateTimeFormat(iso=ISO.NONE)
	private Date leaveEndDate;
	
	@Column(name="typeOfLeave")
	private String typeOfLeave; //TODO - this should be a master
	
	@Column(name="leaveDurationType")
	private String leaveDurationType;	
	
	@Column(name="remarks")
	private String remarks;
	
	@Column(name="availableLeaveBalance")
	private int availableLeaveBalance;
	
	@Column(name="leaveDuration")
	private int leaveDuration;
	
	@ManyToOne()
	@JoinColumn(name="fk_leaveStatus")
	private LeaveStatus leaveStatus;
	
	@Column(name="log",length=1000)
	private String log;
	
	public LeaveRequest() {
		
	}

	public LeaveRequest(Employee requestorName,
			Employee approverName, Date leaveStartDate, Date leaveEndDate,
			String typeOfLeave, String leaveDurationType, String remarks,
			int availableLeaveBalance, int leaveDuration,
			LeaveStatus leaveStatus, String log) {
		super();	
		this.requestorName = requestorName;
		this.approverName = approverName;
		this.leaveStartDate = leaveStartDate;
		this.leaveEndDate = leaveEndDate;
		this.typeOfLeave = typeOfLeave;
		this.leaveDurationType = leaveDurationType;
		this.remarks = remarks;
		this.availableLeaveBalance = availableLeaveBalance;
		this.leaveDuration = leaveDuration;
		this.leaveStatus = leaveStatus;
		this.log = log;
	}

	public Employee getRequestorName() {
		return requestorName;
	}

	public void setRequestorName(Employee requestorName) {
		this.requestorName = requestorName;
	}

	public Employee getApproverName() {
		return approverName;
	}

	public void setApproverName(Employee approverName) {
		this.approverName = approverName;
	}

	public Date getLeaveStartDate() {
		return leaveStartDate;
	}

	public void setLeaveStartDate(Date leaveStartDate) {
		this.leaveStartDate = leaveStartDate;
	}

	public Date getLeaveEndDate() {
		return leaveEndDate;
	}

	public void setLeaveEndDate(Date leaveEndDate) {
		this.leaveEndDate = leaveEndDate;
	}

	public String getTypeOfLeave() {
		return typeOfLeave;
	}

	public void setTypeOfLeave(String typeOfLeave) {
		this.typeOfLeave = typeOfLeave;
	}

	public String getLeaveDurationType() {
		return leaveDurationType;
	}

	public void setLeaveDurationType(String leaveDurationType) {
		this.leaveDurationType = leaveDurationType;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public int getAvailableLeaveBalance() {
		return availableLeaveBalance;
	}

	public void setAvailableLeaveBalance(int availableLeaveBalance) {
		this.availableLeaveBalance = availableLeaveBalance;
	}

	public int getLeaveDuration() {
		return leaveDuration;
	}

	public void setLeaveDuration(int leaveDuration) {
		this.leaveDuration = leaveDuration;
	}

	public String getLog() {
		return log;
	}

	public void setLog(String log) {
		this.log = log;
	}

	public LeaveStatus getLeaveStatus() {
		return leaveStatus;
	}

	public void setLeaveStatus(LeaveStatus leaveStatus) {
		this.leaveStatus = leaveStatus;
	}
	
	
	
}
