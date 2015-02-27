/**
 * 
 */
package com.sobis.client;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.sobis.entity.Book;

/**
 * @author Sudhir
 *
 */
public class Main {

	/**
	 * @param args
	 * @throws SystemException 
	 * @throws HeuristicRollbackException 
	 * @throws HeuristicMixedException 
	 * @throws RollbackException 
	 * @throws SecurityException 
	 */
	public static void main(String[] args) throws SecurityException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException {
		//addBook();
		//getBook();
		updateBook();
		

	}

	private static void updateBook() {
		// TODO Auto-generated method stub

		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		org.hibernate.Transaction txn = session.beginTransaction();
		
		Book book = (Book) session.get(Book.class, 1);		
		book.setTitle("Title changed");
		book.setPrice(book.getPrice()*3);
		session.persist(book);
		txn.commit();
		session.close();
		factory.close(); // not needed to be closed every time
	}

	private static void getBook() {
		// TODO Auto-generated method stub
			
		
	}

	private static void addBook() throws SecurityException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException {
		// TODO Auto-generated method stub
		
		
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		org.hibernate.Transaction txn = session.beginTransaction();
		Book book = new Book(0,"Java training book", 200);
		session.persist(book);
		txn.commit();
		session.close();
		factory.close();
		
	}

}
