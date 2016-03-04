package com.sobis.carparking.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee extends Base {
	
	@Column(name="employeeName")
	private String employeeName;
	
	@Column(name="employeeId")
	private String employeeId;
	
	@Column(name="email")
	private String email;
	
	@OneToOne()
	@JoinColumn(name="fk_image")
	private File image;
	
	@OneToOne()
	@JoinColumn(name="fk_username")
	private User user;
	
	public Employee() {
		
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public File getImage() {
		return image;
	}



	public void setImage(File image) {
		this.image = image;
	}



	public Employee(String employeeName, String employeeId, String email, File image, User user) {
		super();
		this.employeeName = employeeName;
		this.employeeId = employeeId;
		this.email = email;		
		this.image = image;
		this.user = user;
	}



	public String getEmployeeName() {
		return employeeName;
	}



	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}



	public String getEmployeeId() {
		return employeeId;
	}



	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
