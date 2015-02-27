package com.sobis.client;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.sobis.entity.Project;

public class JPAClient {

	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("sobis_pu");
		EntityManager em = entityManagerFactory.createEntityManager();			
		em.getTransaction().begin();
		
		
		Project project = new Project(0, "ACME Corp", new Date());
		em.persist(project);
		em.getTransaction().commit();
		em.close();

	}

}
