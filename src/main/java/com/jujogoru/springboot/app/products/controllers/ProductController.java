package com.jujogoru.springboot.app.products.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.jujogoru.springboot.app.commons.models.entity.Product;
import com.jujogoru.springboot.app.products.models.service.IProductService;

@RestController
public class ProductController {
	
	@Autowired
	private Environment environment;
	
	@Value("${server.port}")
	private Integer port; 
	
	@Autowired
	private IProductService productoService;
	
	@GetMapping("/")
	public List<Product> list(){
		return productoService.findAll().stream().map(product -> {
			//product.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
			product.setPort(port);
			return product;
		}).collect(Collectors.toList());
	}
	
	@GetMapping("/{id}")
	public Product detail(@PathVariable Long id) {
		Product product = productoService.findById(id);
//		product.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		
		
		//TODO Implement a 404 response when there's no product found
		if(product != null) {
			product.setPort(port);			
		}
		
//		try {
//			Thread.sleep(5000L);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		
//		boolean ok = false;
//		if(ok == false) {
//			throw new Exception("Cannot load this product.");
//		}
		
		return product;
	}
	
	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public Product create(@RequestBody Product product) {
		return productoService.save(product);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public Product update(@RequestBody Product product, @PathVariable Long id) {
		
		Product productDb = productoService.findById(id);
		productDb.setName(product.getName());
		productDb.setPrice(product.getPrice());
		
		return productoService.save(productDb);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		productoService.deleteById(id);
	}
}
