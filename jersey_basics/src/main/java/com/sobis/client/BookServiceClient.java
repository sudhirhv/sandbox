package com.sobis.client;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.sobis.model.Book;

public class BookServiceClient {

	public static void main(String[] args) {
		Client client = ClientBuilder.newClient();
		
		WebTarget target = client.target("http://localhost:8080/jersey_basics").path("rest/books");
		
		Response response = target.request().post(Entity.entity(new Book(10, "sdfsdf", 233), MediaType.APPLICATION_JSON));
		
		System.out.println(response.readEntity(String.class));
		
		response = target.request(MediaType.APPLICATION_JSON).get();
		
		System.out.println(response.readEntity(List.class));

	}

}
