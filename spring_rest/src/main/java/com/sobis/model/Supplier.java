package com.sobis.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="suppliers")
public class Supplier {

	@Id
	@Column(name="SUPPLIER_ID")
	private int supplierId;
	
	@Column(name="COMPANY_NAME")
	private String companyName;
	
	public Supplier() {}

	public Supplier(int supplierId, String companyName) {
		super();
		this.supplierId = supplierId;
		this.companyName = companyName;
	}

	public int getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	};
	
	
}
