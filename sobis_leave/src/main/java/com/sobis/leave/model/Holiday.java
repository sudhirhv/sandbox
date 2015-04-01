package com.sobis.leave.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.joda.time.DateTime;

@Entity
@Table(name="holidays")
public class Holiday extends Base {
	
	
	@Column(name="holidayName")
	private String holidayName;
	
	@Column(name="holidayDate")
	private DateTime holidayDate;
	
	public Holiday() {

	}

	public String getHolidayName() {
		return holidayName;
	}

	public void setHolidayName(String holidayName) {
		this.holidayName = holidayName;
	}

	public DateTime getHolidayDate() {
		return holidayDate;
	}

	public void setHolidayDate(DateTime holidayDate) {
		this.holidayDate = holidayDate;
	}

	public Holiday(String holidayName, DateTime holidayDate) {
		super();		
		this.holidayName = holidayName;
		this.holidayDate = holidayDate;
	}
	
}
