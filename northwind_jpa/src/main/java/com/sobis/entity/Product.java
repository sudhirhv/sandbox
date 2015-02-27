/**
 * 
 */
package com.sobis.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * @author Sudhir
 *
 */
@Entity
@Table(name="products")
@NamedQueries({
	@NamedQuery(name="productsAboveAvg", query="select p from Product p "
			+ "where p.unitPrice > (select avg(p2.unitPrice) from Product p2)"),
	@NamedQuery(name="SeaFoodProducts",
				query = "select p from Product p where "
						+ " p.categories.categoryName = 'SeaFood'"
			   )			
})
public class Product {

	public Product(){}
	
	@Id
	@Column(name="PRODUCT_ID")
	private int productId;
	
	@Column(name="PRODUCT_NAME")
	private String productName;
	
	@Column(name="UNIT_PRICE")
	private double unitPrice;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="SUPPLIER_ID")
	private Supplier suppliers;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CATEGORY_ID")
	private Categories categories;

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

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Supplier getSuppliers() {
		return suppliers;
	}

	public void setSuppliers(Supplier suppliers) {
		this.suppliers = suppliers;
	}

	public Categories getCategories() {
		return categories;
	}

	public void setCategories(Categories categories) {
		this.categories = categories;
	}

	public Product(int productId, String productName, double unitPrice) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.unitPrice = unitPrice;		
	}
	
	
	
}
