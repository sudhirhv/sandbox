/**
 * 
 */
package com.sobis.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Sudhir
 *
 */
@Entity
@Table(name="PROJECT")
public class Project implements Serializable {
	
	
	private static final long serialVersionUID = 8626900214640434962L;

	@Id	
	@Column(name="PROJECT_ID")
	private int projectId;
	
	@Column(name="PROJ_NAME")
	private String name;
	
	public Project() {
		// TODO Auto-generated constructor stub
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Project(int projectId, String name) {
		super();
		this.projectId = projectId;
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + projectId;
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
		Project other = (Project) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (projectId != other.projectId)
			return false;
		return true;
	}
	
	
	
	
}
