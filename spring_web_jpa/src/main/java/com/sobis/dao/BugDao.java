package com.sobis.dao;

import java.util.List;

import com.sobis.model.Bug;
import com.sobis.model.Project;

public interface BugDao {

	public void raiseBug(Bug bug);
	
	public void resolveBug(Bug bug);
	
	public List<Bug> getBugsOfProject(Project project);
	
	public List<Bug> getAllBugs();
	
	public Bug getById(int id);
	
}
