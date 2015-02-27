package com.sobis.dao;

import java.util.List;

import com.sobis.model.Project;

public interface ProjectDao {

	public Project getProject(int id);
	 
	public List<Project> getProjects();
	
	
}
