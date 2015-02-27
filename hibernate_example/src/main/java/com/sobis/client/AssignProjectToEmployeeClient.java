/**
 * 
 */
package com.sobis.client;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.sobis.entity.Address;
import com.sobis.entity.Employee;
import com.sobis.entity.EmployeeProject;
import com.sobis.entity.Project;
import com.sobis.entity.Skill;

/**
 * @author Sudhir
 *
 */
public class AssignProjectToEmployeeClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("sobis_pu");
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		
		
		Employee emp1 = em.find(Employee.class, 1);
		Project proj1 = em.find(Project.class, 1);
		
		EmployeeProject empProj = new EmployeeProject();
		empProj.setEmployee(emp1);
		empProj.setProject(proj1);
		empProj.setWorkedFrom(new Date());
		
		em.persist(empProj);
		

		em.getTransaction().commit();
		em.close();
		
	}

}
