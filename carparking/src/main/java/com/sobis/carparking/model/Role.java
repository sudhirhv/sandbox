package com.sobis.carparking.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="roles")
public class Role extends Base {

	private static final long serialVersionUID = -3394245355508127835L;
	
	public String getRoleName() {
		return roleName;
	}


	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}


	@Column(name="roleName")
	private String roleName;
	
	@ManyToMany(mappedBy = "roles")
	private Set<User> users = new HashSet<User>();
	
	
	public Role() {
		// TODO Auto-generated constructor stub
	}	
}
