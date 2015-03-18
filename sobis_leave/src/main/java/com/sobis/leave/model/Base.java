package com.sobis.leave.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="base")
@Inheritance(strategy=InheritanceType.JOINED)

public abstract class Base implements Serializable  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6942134775866295552L;

	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid",strategy = "uuid")	
	@Column(length=32, nullable=false)	
	private String id;
	
	@Column(name="createdOn")		
	private DateTime createdOn;
	
	@Column(name="modifiedOn")
	private DateTime modifiedOn;
	
	@Column(name="isDeleted")
	private boolean isDeleted;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public DateTime getCreatedOn() {
		return createdOn;
	}
	@DateTimeFormat(iso=ISO.DATE_TIME)
	public void setCreatedOn(DateTime createdOn) {
		this.createdOn = createdOn;
	}

	public DateTime getModifiedOn() {
		return modifiedOn;
	}
	
	public void setModifiedOn(DateTime modifiedOn) {
		this.modifiedOn = modifiedOn;
	}
	
	/*public DateTime getModifiedOn() {
		return modifiedOn!=null ? modifiedOn.toDateTime(DateTimeZone.UTC) : null;
		//return (modifiedOn 	!= null)? new DateTime(modifiedOn.getTime()) : null;
	}
	
	public void setModifiedOn(DateTime dateTime) 	{
		this.modifiedOn = dateTime.toDateTime();
		//this.modifiedOn = dateTime.toDate();
	}*/

	public boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Base other = (Base) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}	

	
	
	
}
