package com.sobis.leave.model.security;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.sobis.leave.model.Base;

@Entity
@Table(name="acl_sid")
public class aclSid extends Base {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3297456482529266608L;

	@Column(name="principal")
	private String principal;
	
	@Column(name="sid")
	private String sid;

	public String getPrincipal() {
		return principal;
	}

	public void setPrincipal(String principal) {
		this.principal = principal;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}	
	
}
