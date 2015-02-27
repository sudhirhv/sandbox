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
public class MapProjectsToEmployees {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("sobis_pu");
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		
		Employee emp1 = new Employee();
		emp1.setEmployeeName("Anil");
		
		Project p1 = em.find(Project.class, 1);
		Project p2 = em.find(Project.class, 2);
		
		EmployeeProject empProj = new EmployeeProject();
		empProj.setEmployee(emp1);
		empProj.setProject(p2);
		empProj.setWorkedFrom(new Date());
		
		EmployeeProject empProj1 = new EmployeeProject();
		empProj1.setEmployee(emp1);
		empProj1.setProject(p1);
		empProj1.setWorkedFrom(new Date());
		
		emp1.getProjects().add(empProj1);
		emp1.getProjects().add(empProj);
		
		em.persist(emp1);

		em.getTransaction().commit();
		em.close();
		System.exit(0);
	}

}
