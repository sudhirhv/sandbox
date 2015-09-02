package com.sample.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Banu Prakash [banuprakashc@yahoo.co.in]
 * @version 1.0
 */
public class Order {
	private List<LineItem> items = new ArrayList<LineItem>();
	private Date orderDate = new Date();
	public List<LineItem> getItems() {
		return items;
	}
	public void setItems(List<LineItem> items) {
		this.items = items;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

}
