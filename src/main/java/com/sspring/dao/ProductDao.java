package com.sspring.dao;

import java.util.List;

import com.sspring.bean.Product;

public interface ProductDao {

	public void update(Product product);

	public void delete(int productId);
	
	public void persist(Product product);

	public Product findById(int id);

	public List<Product> findAll();

	public List<Product> findAllForUserId(int userId);

}
