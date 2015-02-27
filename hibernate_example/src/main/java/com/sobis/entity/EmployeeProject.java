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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Sudhir
 *
 */
@Entity
@Table(name="employeeProjects")
public class EmployeeProject {

	public EmployeeProject() {
		
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="employeeId")
	private Employee employee;
	
	@ManyToOne
	@JoinColumn(name="projectId")
	private Project project;

	@Column(name="workedForm")
	private Date workedFrom;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Date getWorkedFrom() {
		return workedFrom;
	}

	public void setWorkedFrom(Date workedFrom) {
		this.workedFrom = workedFrom;
	}

	public EmployeeProject(int id, Employee employee, Project project,
			Date workedFrom) {
		super();
		this.id = id;
		this.employee = employee;
		this.project = project;
		this.workedFrom = workedFrom;
	}
	
	
}
