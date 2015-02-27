/**
 * 
 */
package com.sobis.client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.sobis.entity.Address;
import com.sobis.entity.Employee;
import com.sobis.entity.Skill;

/**
 * @author Sudhir
 *
 */
public class EmployeeProjectClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("sobis_pu");
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		
		
		Skill sk1 = new Skill(0, "sleeping");
		Skill sk2 = new Skill(0, "eating");
		Skill sk3 = new Skill(0, "drinking");
		
		em.persist(sk1);
		em.persist(sk2);
		em.persist(sk3);
		
		Address adr1 = new Address(0, "bekaar street", "bekaar city");
		Address adr2 = new Address(0, "streewith no name", "nameless city");
		
		Employee emp1 = new Employee();
		emp1.setEmployeeAddress(adr1);
		emp1.setEmployeeName("sudhir");
		
		Employee emp2 = new Employee();
		emp2.setEmployeeAddress(adr2);
		emp2.setEmployeeName("harshal");
		
		em.persist(emp1);
		em.persist(emp2);

		em.getTransaction().commit();
		em.close();
		
	}

}
