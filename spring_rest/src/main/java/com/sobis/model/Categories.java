package com.sobis.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="categories")
@XmlRootElement
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
	@Transient	
	@JsonIgnore
	private byte[] picture;
	
	//@OneToMany(mappedBy="categories", fetch=FetchType.EAGER)
	@OneToMany(fetch=FetchType.EAGER)	
	@JoinColumn(name="category_id")
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
