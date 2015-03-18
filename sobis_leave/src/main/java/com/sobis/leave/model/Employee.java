/**
 * 
 */
package com.sobis.leave.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sobis.leave.model.serializer.EmployeeSerializer;

/**
 * @author Sudhir
 *
 */
@Entity
@Table(name="employee")
//@JsonIdentityInfo(generator=ObjectIdGenerators.UUIDGenerator.class, property="@id")
//@JsonSerialize(using = EmployeeSerializer.class)
public class Employee extends Base {

	private static final long serialVersionUID = 6404049515635616400L;	

	
	@Column(name="employeeName")
	private String employeeName;
	
	@Column(name="employeeId")
	private String employeeId;
		
	@Column(name="email")
	private String email;
	
	@ManyToOne(cascade={CascadeType.ALL}) // self join
    @JoinColumn(name="managerId")	
	
    private Employee manager;
	
	@OneToMany(mappedBy="manager", fetch=FetchType.LAZY)	
	private Set<Employee> reportees = new HashSet<Employee>();
			
	
	public Employee(String employeeName, String employeeId, String email,
			Employee manager, Set<Employee> reportees) {
		super();
		this.employeeName = employeeName;
		this.employeeId = employeeId;
		this.email = email;
		this.manager = manager;
		this.reportees = reportees;		
	}
	
	@JsonSerialize(using = EmployeeSerializer.class)
	public Employee getManager() {
		return manager;
	}

	public void setManager(Employee manager) {
		this.manager = manager;
	}

	public Employee() {

	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	
	
}
