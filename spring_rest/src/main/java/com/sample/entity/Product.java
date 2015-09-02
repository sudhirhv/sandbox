/**
 * 
 */
package com.sample.entity;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Banu Prakash [banuprakashc@yahoo.co.in]
 * @version 1.0
 */
@XmlRootElement
public class Product {
	private int id;
	private String name;
	private double price;
	/**
	 * 
	 */
	public Product() {
	}
	/**
	 * @param id
	 * @param name
	 * @param price
	 */
	public Product(int id, String name, double price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
}
