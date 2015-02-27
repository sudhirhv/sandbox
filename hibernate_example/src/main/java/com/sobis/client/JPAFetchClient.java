package com.sobis.client;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.sobis.entity.Project;

public class JPAFetchClient {

	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("sobis_pu");
		EntityManager em = entityManagerFactory.createEntityManager();			
		
		Project project = em.find(Project.class, 2);
		System.out.println(project.getName());

		em.close();

	}

}
