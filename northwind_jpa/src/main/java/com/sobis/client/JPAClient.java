package com.sobis.client;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.LockModeType;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.sobis.entity.Categories;
import com.sobis.entity.Product;
import com.sobis.entity.Supplier;

public class JPAClient {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("sobis_pu");
		
		
		//getProducts(emf);
		//getCategories(emf);
		//getJoinedProducts(emf);
		//getJoinedProductsWithoutFetch(emf);
		//subQueryExample(emf);
		//aggregate(emf);
		//sqlQuery(emf);
		updateQuery(emf);
		System.exit(0);
//		

	}
	
	private static void updateQuery(EntityManagerFactory emf) {
		
		EntityManager em = emf.createEntityManager();
		
		/*
		Product p = em.find(Product.class, 1, LockModeType.OPTIMISTIC);		
		Product p = em.find(Product.class, 1, LockModeType.PESSIMISTIC_WRITE);
		This is one method to lock a record, but we must lock it only before commit, by using the em.lock() method */
				
		
		String jpl = "Update Product p set p.unitPrice = p.unitPrice + 100 ";		
		Query query = em.createQuery(jpl);		
		em.getTransaction().begin();
		int rows = query.executeUpdate();
		em.getTransaction().commit();
		System.out.println(rows +" -  cahnged");
		em.close();
	}
	
	private static void sqlQuery(EntityManagerFactory emf) {
		EntityManager em = emf.createEntityManager();
		String sqlquery = "Select * from orders";
		Query query = em.createNativeQuery(sqlquery);		
		List<Object[]> products = query.getResultList();
		System.out.println(products.size());
		for (int i = 0; i < products.size(); i++) {
			Object[] objs = products.get(i);
			System.out.println(objs[0]+"\t"+objs[1]);
		}
		
		//map sql queries to entities
		
		/*Query query = em.createNativeQuery(sqlquery, Product.class);		
		List<Product> products = query.getResultList();*/
			
		em.close();	
	}
	private static void aggregate(EntityManagerFactory emf) {
		EntityManager em = emf.createEntityManager();
		String jpl = "select p.categories.categoryName, "
				+ "sum(p.unitPrice) from Product p "
				+ "group by p.categories";
		String jpl1 = "select p.categories.categoryName, "
				+ "sum(p.unitPrice) from Product p "
				+ "group by p.categories "
				+ "order by sum(p.unitPrice) desc";
		Query query = em.createQuery(jpl1);
		List<Object[]> products = query.getResultList();
		System.out.println(products.size());
		for (int i = 0; i < products.size(); i++) {
			Object[] objs = products.get(i);
			System.out.println(objs[0]+"\t"+objs[1]);
		}
			
		em.close();	
		
	}
	private static void subQueryExample(EntityManagerFactory emf) {
		EntityManager em = emf.createEntityManager();
		Query query = em.createNamedQuery("productsAboveAvg");
		List<Product> products = query.getResultList();
		System.out.println(products.size());
		for (Product p : products) {
				System.out.println(p.getProductName() +": "+p.getUnitPrice());
		}		
		
		Query query1 = em.createNamedQuery("SeaFoodProducts");
		List<Product> products1 = query1.getResultList();
		System.out.println(products1.size());
		for (Product p : products1) {
				System.out.println(p.getProductName() +": "+p.getUnitPrice());
		}		
		
		
		em.close();	
		
	}
	// not a useful example
	private static void getJoinedProductsWithoutFetch(EntityManagerFactory emf) {	
		EntityManager em = emf.createEntityManager();	
		String jpl = "Select p, c, s from Product p "
					+ "left outer join p.categories c "
					+ "left outer join p.suppliers s "
					+ "where s.companyName like :supplier and c.categoryName like 'C%'";
		
		Query query = em.createQuery(jpl);
		query.setParameter("supplier", "%No%");
		
		List<Object[]> objects = query.getResultList();
		for (Object[] objs : objects) {
				if(objs[0]!=null) {
					Product p = (Product) objs[0];
					//TODO - does this generate more queries , check
					//System.out.println(p.getProductName()+": "+p.getCategories().getCategoryName()+": "+p.getSuppliers().getCompanyName());
					System.out.println(p.getProductName());
				}
				if(objs[1]!=null) {
					Categories c = (Categories) objs[1];
					System.out.println(c.getCategoryName());
				}
				if(objs[2]!=null) {
					Supplier s = (Supplier) objs[2];
					System.out.println(s.getCompanyName());
				}
		}
		em.close();
	}

	private static void getJoinedProducts(EntityManagerFactory emf) {	
		EntityManager em = emf.createEntityManager();	
		String jpl = "Select p, c, s from Product p "
					+ "left outer join fetch p.categories c "
					+ "left outer join fetch p.suppliers s "
					+ "where s.companyName like :supplier and c.categoryName like 'C%'";
		
		Query query = em.createQuery(jpl);
		query.setParameter("supplier", "%No%");
		
		List<Product> products = query.getResultList();
		for (Product p : products) {
				System.out.println(p.getProductName() +": "+p.getCategories().getCategoryName()+": "+p.getSuppliers().getCompanyName()); ;
		}		
		em.close();
	}

	private static void getCategories(EntityManagerFactory emf) {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();			
		
		String jpl = "Select c from Categories c";
		//Query query = em.createQuery(jpl);
		TypedQuery<Categories> query = em.createQuery(jpl, Categories.class);
		
		for (Categories c : query.getResultList()) {
			System.out.println(c.getCategoryName());
			Set<Product> products = c.getProducts();
			for (Product product : products) {
				System.out.println(product.getProductName()+": "+product.getUnitPrice());
			}
			
		}		
		em.close();		
	}

	private static void getProducts(EntityManagerFactory emf) {
		EntityManager em = emf.createEntityManager();			
				
		//String jpl = "Select p from Product p";
		String jpl = "Select p from Product p where p.productName like :prd and p.unitPrice > :price";
			
		Query query = em.createQuery(jpl);
		query.setParameter("prd", "%chef%");
		query.setParameter("price", 10.00);
		
		//This will give result set with type casted
		//TypedQuery<Product> query = em.createQuery(jpl, Product.class);
		
		/*query.setFirstResult(0);
		query.setMaxResults(5);*/
		
		List<Product> products = query.getResultList();
		
		for (Product product : products) {
			System.out.println(product.getProductName());
		}		
		em.close();
		
	}

}

