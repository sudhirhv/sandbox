package com.sobis.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.sobis.model.Book;

public class BookRepository {

	private static List<Book> list = new ArrayList<Book>();
	
	static {
		list.add(new Book(100, "Dummy book", 200.00));
		list.add(new Book(200, "Dummy book1", 300.00));
		list.add(new Book(300, "Dummy book2", 400));
	}
	
	public static List<Book> getAllBooks() {
		return list;
	}
	
	public static void addBook(Book b) {
		list.add(b);
	}

	public static Book getBook(int id){
		Book book = null;
		for (Book b : list) {
			if(b.getBookId()==id) {
				book = b;
				break;
			}
		}
		return book;
	}
	
	public static void removeBook(int id) {
		Iterator<Book> iter = list.iterator();
		while(iter.hasNext()) {
			Book b = iter.next();
			if(b.getBookId() == id) {
				iter.remove();
				break;
			}
		}
	}
}
