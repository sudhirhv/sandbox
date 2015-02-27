package com.sobis.leave.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="holidays")
public class Holiday implements Serializable {
	
	private static final long serialVersionUID = 7988998476400395303L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	@Column(name="holidayId")
	private int holidayId;
	
	@Column(name="holidayName")
	private String holidayName;
	
	@Column(name="holidayDate")
	private Date holidayDate;
	
	public Holiday() {

	}

	public int getHolidayId() {
		return holidayId;
	}

	public void setHolidayId(int holidayId) {
		this.holidayId = holidayId;
	}

	public String getHolidayName() {
		return holidayName;
	}

	public void setHolidayName(String holidayName) {
		this.holidayName = holidayName;
	}

	public Date getHolidayDate() {
		return holidayDate;
	}

	public void setHolidayDate(Date holidayDate) {
		this.holidayDate = holidayDate;
	}

	public Holiday(int holidayId, String holidayName, Date holidayDate) {
		super();
		this.holidayId = holidayId;
		this.holidayName = holidayName;
		this.holidayDate = holidayDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + holidayId;
		result = prime * result
				+ ((holidayName == null) ? 0 : holidayName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Holiday other = (Holiday) obj;
		if (holidayId != other.holidayId)
			return false;
		if (holidayName == null) {
			if (other.holidayName != null)
				return false;
		} else if (!holidayName.equals(other.holidayName))
			return false;
		return true;
	}

	
}
