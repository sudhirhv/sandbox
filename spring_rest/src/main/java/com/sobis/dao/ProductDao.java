package com.sobis.dao;

import java.util.List;

import com.sobis.model.Categories;
import com.sobis.model.Product;



public interface ProductDao {
	
	public List<Product> getAllProducts();
	
	public Product getProduct(int productId);
	
	public void addProduct(Product product);
	
	public void deleteProduct(int productId);
	
	public List<Categories> getCategories();
}
