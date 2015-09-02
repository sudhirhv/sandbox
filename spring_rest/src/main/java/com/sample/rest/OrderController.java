package com.sample.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sample.entity.Customer;
import com.sample.entity.Order;
import com.sample.entity.Product;
import com.sample.service.OrderService;

@Controller
public class OrderController {

	@Autowired
	private OrderService orderService;

	@RequestMapping(value = "/customers", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody List<Customer> getCustomers() {
		return orderService.getAllCustomers();
	}

	@RequestMapping(value = "/customers", method = RequestMethod.POST, headers = "Accept=application/json")
	public @ResponseBody List<Customer> add(@RequestBody Customer customer) {
		orderService.addCustomer(customer);
		return orderService.getAllCustomers();
	}

	@RequestMapping(value = "/products", method = RequestMethod.GET, produces = {
			"application/json", "application/xml" }, headers = "Accept=application/json,application/xml")
	public @ResponseBody List<Product> getProducts() {
		return orderService.getProducts();
	}
	
	@RequestMapping(value = "/orders/{id}", 
			method = RequestMethod.GET, produces = {
			"application/json", "application/xml" }, 
			headers = "Accept=application/json,application/xml")
	public @ResponseBody List<Order> getOrders(@PathVariable("id")int id) {
		return orderService.getOrders(id);
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody Customer login(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
		return orderService.login(firstName, lastName);		
	}
}
