package com.sobis.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="products")
@XmlRootElement
public class Product {

	@Id
	@Column(name="product_id")
	@XmlElement(name="product_id")
	private int productId;
	
	@Column(name="product_name")
	@XmlElement(name="product_name")
	private String productName;
	
	
	@Column(name="unit_price")
	@XmlElement(name="unit_price")
	private double unitPrice;
	
	@Column(name="discontinued")
	private int discontinued; 

	public int getProductId() {
		return productId;
	}


	public void setProductId(int productId) {
		this.productId = productId;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public Product(int productId, String productName, double unitPrice) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.unitPrice = unitPrice;
		this.discontinued = 0;
	}


	public int getDiscontinued() {
		return discontinued;
	}


	public void setDiscontinued(int discontinued) {
		this.discontinued = discontinued;
	}


	public double getUnitPrice() {
		return unitPrice;
	}


	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	public Product() {
		
	}
	
	
}
