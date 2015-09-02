package com.sobis.leave.model.security;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.sobis.leave.model.Base;

@Entity
@Table(name="roles")
public class Role extends Base {
	  
	/**
	 * 
	 */
	private static final long serialVersionUID = 1816727109299527659L;

	@Column(name="role")
	private String role;
	
	@ManyToMany(mappedBy="roles", fetch=FetchType.LAZY)
	private Set<User> users = new HashSet<User>();
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public Role() {
		
	}
	
	public Role(String role) {
		super();
		this.role = role;
	}
	
}
