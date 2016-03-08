package com.sobis.carparking.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User extends Base {
	
	@Column(name="userName")
	private String userName;
	
	@Column(name="password")
	private String password;
	
	@Column(name="isActive")
	private boolean isActive;
	
	 
	@ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name="user_roles",
        joinColumns = {@JoinColumn(name="user_id")},
        inverseJoinColumns = {@JoinColumn(name="role_id")}
    )
    private Set<Role> roles = new HashSet<Role>();
	
	public Set<Role> getRoles() {
		return roles;
	}



	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}



	public User() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public User(String userName, String password, boolean isActive) {
		super();
		this.userName = userName;
		this.password = password;
		this.isActive = isActive;
	}



	public String getUserName() {
		return userName;
	}
	public void setUsername(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
}
