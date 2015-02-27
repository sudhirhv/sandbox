/**
 * 
 */
package com.sobis.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Sudhir
 *
 */
@Entity
@Table(name="PROJECT")

public class Project {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="project_id")
	private int projectId;
	
	@Column(name="project_name", length=200, nullable=false)
	private String name;
	
	@Column(name="start_Date")
	@Temporal(TemporalType.DATE)
	private Date startDate;
	
	public Project() {
		// TODO Auto-generated constructor stub
	}

	public Project(int projectId, String name, Date startDate) {
		super();
		this.projectId = projectId;
		this.name = name;
		this.startDate = startDate;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	
	
	
}
