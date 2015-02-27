/**
 * 
 */
package com.sobis.leave.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Sudhir
 *
 */
@Entity
@Table(name="employee")
public class Employee implements Serializable {

	private static final long serialVersionUID = 6404049515635616400L;	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	@Column(name="employeeId")
	private int id;
	
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((employeeName == null) ? 0 : employeeName.hashCode());
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
		Employee other = (Employee) obj;
		if (id != other.id)
			return false;
		if (employeeName == null) {
			if (other.employeeName != null)
				return false;
		} else if (!employeeName.equals(other.employeeName))
			return false;
		return true;
	}

	public Employee(int id, String employeeName, String email, String approver,
			String approverEmail) {
		super();
		this.id = id;
		this.employeeName = employeeName;
		this.email = email;
		this.approver = approver;
		this.approverEmail = approverEmail;
	}

	
	
	
}
