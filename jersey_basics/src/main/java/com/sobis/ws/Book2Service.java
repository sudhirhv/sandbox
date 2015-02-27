package com.sobis.ws;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.sobis.dao.BookRepository;
import com.sobis.model.Book;

@Path("/bks")
public class Book2Service {
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public Book getBook(@QueryParam("id") int id) {
		return BookRepository.getBook(id);
	}
	
	@POST
	
	public Response createBook(@FormParam("bookId") int bookId,
			@FormParam("title") String title,
			@FormParam("price") double price) { Book book = new Book(bookId, title, price);
			 {
		BookRepository.addBook(book);
		return Response.status(201).entity("Book "+book.getTitle()+" sucessfully added").build();
			 }
	}
	
}
