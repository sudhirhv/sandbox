/**
 * 
 */
package com.sobis.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author Sudhir
 *
 */
@Entity
@Table(name="employee")
public class Employee {

	public Employee() {
		
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="employeeId")
	private int employeeId;
	
	@Column(name="employeeName")
	private String employeeName;
	
	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="houseAddress", nullable=true) // without this, it will create a link table
	private Address employeeAddress;
	
	public Set<EmployeeProject> getProjects() {
		return projects;
	}

	public void setProjects(Set<EmployeeProject> projects) {
		this.projects = projects;
	}
	@OneToMany(mappedBy="employee", cascade=CascadeType.PERSIST)
	private Set<EmployeeProject> projects = new HashSet<EmployeeProject>();
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="employeeSkills", joinColumns= 
			{@JoinColumn(name="empId")},
			inverseJoinColumns = {@JoinColumn(name="skillId")})
	
	private Set<Skill> skills = new HashSet<Skill>();

	public Set<Skill> getSkills() {
		return skills;
	}

	public void setSkills(Set<Skill> skills) {
		this.skills = skills;
	}

	public Employee(int employeeId, String employeeName, Address employeeAddress) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeAddress = employeeAddress;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public Address getEmployeeAddress() {
		return employeeAddress;
	}

	public void setEmployeeAddress(Address employeeAddress) {
		this.employeeAddress = employeeAddress;
	}
	
	
	
}
