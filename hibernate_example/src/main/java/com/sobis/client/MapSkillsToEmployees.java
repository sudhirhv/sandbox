/**
 * 
 */
package com.sobis.client;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Criteria;

import com.sobis.entity.Address;
import com.sobis.entity.Employee;
import com.sobis.entity.EmployeeProject;
import com.sobis.entity.Project;
import com.sobis.entity.Skill;

/**
 * @author Sudhir
 *
 */
public class MapSkillsToEmployees {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("sobis_pu");
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		
		Employee emp1 = em.find(Employee.class, 2);
		Skill sk1 = em.find(Skill.class, 1);
		Skill sk2 = em.find(Skill.class, 2);
				
		Employee emp2 = em.find(Employee.class, 3);
		
		Skill sk3 = em.find(Skill.class, 3);
				
		emp1.getSkills().add(sk1);
		emp1.getSkills().add(sk2);		
		emp2.getSkills().add(sk3);
		
		em.merge(emp1);
		em.merge(emp2);	
		

		em.getTransaction().commit();
		em.close();
		System.exit(0);
	}

}
