package com.jujogoru.springboot.app.products.models.service;

import java.util.List;

import com.jujogoru.springboot.app.commons.models.entity.Product;

public interface IProductService {
	
	public List<Product> findAll();
	public Product findById(Long id);
	
	public Product save(Product product);
	
	public void deleteById(Long id);
}
