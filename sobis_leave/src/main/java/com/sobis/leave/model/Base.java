package com.sobis.leave.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Base implements Serializable  {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	@Column(name="id")
	private int id;
	
	@Column(name="createdOn")
	private Date createdOn;
	
	@Column(name="modifiedOn")
	private Date modifiedOn;
	
	@Column(name="isDeleted")
	private int isDeleted;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	public int getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}

	
	
}
