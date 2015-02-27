package com.sobis.dao.jpaimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.sobis.dao.ProjectDao;
import com.sobis.model.Project;
@Repository
public class ProjectDaoJpaImpl implements ProjectDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Project getProject(int id) {		
		return entityManager.find(Project.class, id);
	}

	@Override
	public List<Project> getProjects() {
		TypedQuery<Project> query = entityManager.createQuery("select p from Project p", Project.class);		
		return query.getResultList();
	}

}
