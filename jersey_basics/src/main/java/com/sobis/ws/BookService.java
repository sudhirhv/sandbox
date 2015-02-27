package com.sobis.ws;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.sobis.dao.BookRepository;
import com.sobis.model.Book;

@Path("/books")
public class BookService {
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public List<Book> getBook() {
		return BookRepository.getAllBooks();
	}
	
	@GET
	@Path("{id}")
	@Produces({MediaType.APPLICATION_JSON})
	public Book getBookById(@PathParam("id") int id) {
		return BookRepository.getBook(id);
	}
	
	
	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	public Response createBook(Book b) {
		BookRepository.addBook(b);
		return Response.status(201).entity("Book "+b.getTitle()+" sucessfully added").build();
	}
	
	@DELETE
	@Consumes({MediaType.APPLICATION_JSON})
	public Response deleteBook(Book b) {
		String bookTitle = b.getTitle();
		BookRepository.removeBook(b.getBookId());
		
		return Response.status(201).entity("Book "+bookTitle+" sucessfully removed").build();
	}
	
	
}
