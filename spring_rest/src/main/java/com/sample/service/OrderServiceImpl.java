/**
 * 
 */
package com.sample.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sample.entity.Customer;
import com.sample.entity.LineItem;
import com.sample.entity.Order;
import com.sample.entity.Product;

/**
 * @author Banu Prakash
 *
 */
@Service
public class OrderServiceImpl implements OrderService {

	private static List<Customer> customers = new ArrayList<Customer>();
	private static List<Product> products = new ArrayList<Product>();
	
	static {
		Customer c1 = new Customer(100, "Banu", "Prakash", "1st A Main, Yelahanka", "Bangalore","male");
		Customer c2 = new Customer(101, "Surya", "Prakash", "1234 Anywhere St.", "Mumbai","male");
		Customer c3 = new Customer(102, "Banu", "Chander", "89 W. Center St.", "Delhi","male");
		Customer c4 = new Customer(103, "Swetha", "Naveen", "M.G.Road", "Bangalore","female");
		Customer c5 = new Customer(104, "Kavitha", "Banu", "1st A Main, Yelahanka", "Bangalore","female");
		Customer c6 = new Customer(105, "Rahul", "Dravid", "455 7th Ave.", "Bangalore","male");
		Customer c7 = new Customer(106, "Nithya", "Sharma", "5434 Somewhere Street.", "Delhi","female");
		Customer c8 = new Customer(107, "Preeti", "Sharma", "5434 Somewhere Street.", "Delhi","female");
		Customer c9 = new Customer(108, "Bharath", "Reddy", "900 Pipeline Street.", "Bangalore","male");
		Customer c10 = new Customer(109, "Karthik", "Y", "879 E.Street.", "Bangalore","male");
		
		customers.add(c1);customers.add(c2);customers.add(c3);customers.add(c4);customers.add(c5);
		customers.add(c6);customers.add(c7);customers.add(c8);customers.add(c9);customers.add(c10);
		
		Product p1 = new Product(1, "L.G Washing Machine", 23000.90);
		Product p2 = new Product(2, "MotoG Mobile", 12999.90);
		Product p3 = new Product(3, "Samsung s6", 45000.00);
		Product p4 = new Product(4, "iPhone 6", 53000.90);
		
		products.add(p1);
		products.add(p2);
		products.add(p3);
		products.add(p4);
		
		Order c1Orders  = new Order();
		/*c1Orders.getItems().add(new LineItem(p1,1,p1.getPrice()));
		c1Orders.getItems().add(new LineItem(p2,2,p2.getPrice()*2));*/
		
		c1Orders.getItems().add(new LineItem(p1));
		c1Orders.getItems().add(new LineItem(p2));

		
		c1.getOrders().add(c1Orders);
		
		Order c2Orders  = new Order();
		/*c2Orders.getItems().add(new LineItem(p1,1,p1.getPrice()));
		c2Orders.getItems().add(new LineItem(p4,1,p4.getPrice()));*/
		
		c1Orders.getItems().add(new LineItem(p3));
		c1Orders.getItems().add(new LineItem(p4));
		
		
		c2.getOrders().add(c1Orders);
		c2.getOrders().add(c2Orders);
		
		
		Order c3Orders = new Order();
		c3Orders.getItems().add(new LineItem(p3,1,p3.getPrice()));
		
		c4.getOrders().add(c3Orders);
	}
	/* (non-Javadoc)
	 * @see com.sample.service.OrderService#getAllCustomers()
	 */
	@Override
	public List<Customer> getAllCustomers() {
		return customers;
	}

	/* (non-Javadoc)
	 * @see com.sample.service.OrderService#getCustomer(int)
	 */
	@Override
	public Customer getCustomer(int id) {
		Customer customer = null;
			for (Customer c : customers) {
				if(c.getId() == id) {
					customer = c;
					break;
				}
			}
		return customer;
	}

	/* (non-Javadoc)
	 * @see com.sample.service.OrderService#getOrders(int)
	 */
	@Override
	public List<Order> getOrders(int customerId) {
		Customer c = getCustomer(customerId);
		return c.getOrders();
	}

	@Override
	public void addCustomer(Customer customer) {
		customers.add(customer);
	}

	@Override
	public List<Product> getProducts() {
		return products;
	}

	@Override
	public Customer login(String firstName, String lastName) {
		Customer customer = null;
		for (Customer c : customers) {
			if(c.getFirstName().equals(firstName) && c.getLastName().equals(lastName)) {
				customer = c;
				break;
			}
		}
		return customer;
	}

}
