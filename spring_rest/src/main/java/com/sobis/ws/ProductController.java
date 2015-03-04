package com.sobis.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sobis.dao.ProductDao;
import com.sobis.model.Product;

@Controller
public class ProductController {

	@Autowired
	private ProductDao productDao;
	
	@RequestMapping(value="/products",
					method=RequestMethod.GET,
					headers="accept=application/json")
	public @ResponseBody List<Product> getProducts() {
		return productDao.getAllProducts();
	}
	
	@RequestMapping(value="/products",
			method=RequestMethod.POST,
			headers="accept=application/json")
	public @ResponseBody List<Product> add(@RequestBody Product product) {
		productDao.addProduct(product);
		return productDao.getAllProducts();
	}
	
	
	
}
