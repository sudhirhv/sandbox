/**
 * 
 */
package com.sample.service;

import java.util.List;

import com.sample.entity.Customer;
import com.sample.entity.Order;
import com.sample.entity.Product;

/**
 * @author Banu Prakash
 *
 */
public interface OrderService {
	
	List<Customer> getAllCustomers();
	
	Customer getCustomer(int id);
	
	void addCustomer(Customer customer);
	
	List<Order> getOrders(int customerId);
	
	List<Product> getProducts();
	
	Customer login(String firstName, String lastName);
}
