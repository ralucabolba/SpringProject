package com.sspring.dao;

import java.util.List;

import com.sspring.bean.Product;

public interface ProductDao {

	public boolean add(Product product);

	public boolean update(Product product);

	public boolean delete(int productId);

	public Product findById(int id);

	public List<Product> findAll();

	public List<Product> findAllForUserId(int userId);

}
