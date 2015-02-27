/**
 * 
 */
package com.sobis.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Sudhir
 *
 */
@Entity
@Table(name="PROJECT_BUGS")
public class Bug implements Serializable {

	private static final long serialVersionUID = -5591137111242984595L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int bugId;
	
	@Column(name="BUG_DESC")
	private String description;
	
	@ManyToOne()
	@JoinColumn(name="RAISED_BY")
	private Employee raisedBy;
	
	@ManyToOne()
	@JoinColumn(name="RESOLVED_BY")
	private Employee resolvedBy;
	
	@Column(name="RAISED_DATE")
	private Date raisedDate;
	
	@Column(name="RESOLVED_DATE")
	private Date resolvedDate;
	
	@ManyToOne
	@JoinColumn(name="PROJECT_ID")
	private Project project;

	public int getBugId() {
		return bugId;
	}

	public void setBugId(int bugId) {
		this.bugId = bugId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Employee getRaisedBy() {
		return raisedBy;
	}

	public void setRaisedBy(Employee raisedBy) {
		this.raisedBy = raisedBy;
	}

	public Employee getResolvedBy() {
		return resolvedBy;
	}

	public void setResolvedBy(Employee resolvedBy) {
		this.resolvedBy = resolvedBy;
	}

	public Date getRaisedDate() {
		return raisedDate;
	}

	public void setRaisedDate(Date raisedDate) {
		this.raisedDate = raisedDate;
	}

	public Date getResolvedDate() {
		return resolvedDate;
	}

	public void setResolvedDate(Date resolvedDate) {
		this.resolvedDate = resolvedDate;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bugId;
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
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
		Bug other = (Bug) obj;
		if (bugId != other.bugId)
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		return true;
	}
	
	
}
