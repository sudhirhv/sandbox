/**
 * 
 */
package com.sobis.leave.model;

import javax.persistence.Column;
import javax.persistence.Entity;
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
		
	@Column(name="email")
	private String email;
	
	@Column(name="approver")
	private String approver;
	
	@Column(name="approverEmail")
	private String approverEmail;
	
	public String getApprover() {
		return approver;
	}

	public void setApprover(String approver) {
		this.approver = approver;
	}

	public String getApproverEmail() {
		return approverEmail;
	}

	public void setApproverEmail(String approverEmail) {
		this.approverEmail = approverEmail;
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

	
	public Employee(String employeeName, String email, String approver,
			String approverEmail) {
		super();		
		this.employeeName = employeeName;
		this.email = email;
		this.approver = approver;
		this.approverEmail = approverEmail;
	}

	
	
	
}
