package com.sspring.service;

import java.util.List;

import com.sspring.bean.Product;
import com.sspring.bean.User;

public interface ProductService {
	public void add(Product product, User user);

	public void update(Product product, User user);

	public void delete(int productId, User user);
	
	public Product findById(int productId);
	
	public List<Product> findAll();

	public List<Product> findAllForUserId(int userId);
}
