package com.sobis.carparking.dao.jpaimpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.sobis.carparking.dao.FileDao;
import com.sobis.carparking.model.File;

@Repository
public class FileDaoJpaImpl implements FileDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void addFile(File blob) {
		entityManager.persist(blob);
		
	}

	@Override
	public File getFile(String fileId) {
		return entityManager.find(File.class, fileId);	
	}

	@Override
	public void removeFile(File blob) {
		// TODO Auto-generated method stub
		
	}

}
