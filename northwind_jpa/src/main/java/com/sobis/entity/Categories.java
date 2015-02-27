package com.sobis.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="categories")
public class Categories {

	public Categories() {}
	
	@Id
	@Column(name="CATEGORY_ID")
	private int categoryId;
	
	@Column(name="CATEGORY_NAME")
	private String categoryName;
	
	@Lob
	@Basic(fetch=FetchType.LAZY)
	@Column(name="PICTURE")
	private byte[] picture;
	
	@OneToMany(mappedBy="categories")	
	private Set<Product> products = new HashSet<Product>();

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public byte[] getPicture() {
		return picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}

	public Categories(int categoryId, String categoryName, byte[] picture) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.picture = picture;
	}
	
	
	
}
