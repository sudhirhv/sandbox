/**
 * 
 */
package com.sample.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Banu Prakash [banuprakashc@yahoo.co.in]
 * @version 1.0
 */
public class Customer {
	private int id;
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String gender;
	
	private List<Order> orders = new ArrayList<Order>();
	/**
	 * 
	 */
	public Customer() {
	}
	/**
	 * @param id
	 * @param firstName
	 * @param lastName
	 * @param address
	 * @param city
	 */
	public Customer(int id, String firstName, String lastName, String address,
			String city, String gender) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.gender = gender;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
}
