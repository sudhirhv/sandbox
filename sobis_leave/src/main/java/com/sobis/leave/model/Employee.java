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

/**
 * @author Sudhir
 *
 */
@Entity
@Table(name="employee")
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
