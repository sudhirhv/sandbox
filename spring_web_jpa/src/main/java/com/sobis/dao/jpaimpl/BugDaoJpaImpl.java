package com.sobis.dao.jpaimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.sobis.dao.BugDao;
import com.sobis.model.Bug;
import com.sobis.model.Project;

@Repository
public class BugDaoJpaImpl implements BugDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void raiseBug(Bug bug) {
		entityManager.persist(bug);

	}

	@Override
	public void resolveBug(Bug bug) {
		entityManager.merge(bug);
	}

	@Override
	public List<Bug> getBugsOfProject(Project project) {
		TypedQuery<Bug> query = entityManager.createQuery("select b from Bug b where b.project :prj", Bug.class);
		query.setParameter("prj", project);
		return query.getResultList();
	}

	@Override
	public List<Bug> getAllBugs() {
		TypedQuery<Bug> query = entityManager.createQuery("select b from Bug b where b.resolvedDate is null", Bug.class);		
		return query.getResultList();
	}

	@Override
	public Bug getById(int id) {
		return entityManager.find(Bug.class, id);		 
	}

}
