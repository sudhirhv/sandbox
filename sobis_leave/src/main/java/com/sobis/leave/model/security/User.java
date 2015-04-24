package com.sobis.leave.model.security;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.sobis.leave.model.Base;

@Entity
@Table(name="users")

public class User extends Base {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 585172436801635176L;

	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@Column(name="enabled")
	private int enabled;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}
	
	
	
}
