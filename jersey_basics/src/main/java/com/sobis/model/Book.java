package com.sobis.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Book {
		
	//@Transient is used for those variables that you dont want to persist or output or scan
	@XmlElement(name="book_id")
	private int bookId;
	
	
	private String title;
	
	

	public Book(int bookId, String title, double price) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.price = price;
	}

	public int getBookId() {
		return bookId;
	}
	
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}	public String getTitle() {
		return title;
	}	public void setTitle(String title) {
		this.title = title;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}	private double price;
	
	public Book(){
		
	}


}
