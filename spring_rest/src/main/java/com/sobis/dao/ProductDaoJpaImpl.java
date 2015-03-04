package com.sobis.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.sobis.model.Categories;
import com.sobis.model.Product;

@Repository
@EnableTransactionManagement //shortcut, we are making dao as transactional..ideally we must use a service
@Transactional
public class ProductDaoJpaImpl implements ProductDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Product> getAllProducts() {
		TypedQuery<Product> query = entityManager.createQuery("select p from Product p", Product.class);
		return query.getResultList();			
	}

	@Override
	public Product getProduct(int productId) {
		return entityManager.find(Product.class, productId);
	}

	@Override
	public void addProduct(Product product) {
		entityManager.persist(product);
	}

	@Override
	public void deleteProduct(int productId) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Categories> getCategories() {
		TypedQuery<Categories> query = entityManager.createQuery("select c from Categories c", Categories.class);
		return query.getResultList();
	}

}
