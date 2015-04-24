package com.sobis.leave.model.security;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sobis.leave.model.Base;

@Entity
@Table(name="authorities")
public class authority extends Base {

	/**
	 * 
	 */
	private static final long serialVersionUID = 725272902549772969L;

	@Column(name="authority")
	private String authority;
	
	@ManyToOne
	@JoinColumn(name="fk_username")
	private User username;

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public User getUsername() {
		return username;
	}

	public void setUsername(User username) {
		this.username = username;
	}
	
	
}
