package com.jujogoru.springboot.app.products.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.jujogoru.springboot.app.commons.models.entity.Product;

public interface ProductDao extends CrudRepository<Product, Long>{

}
