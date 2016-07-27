package com.sspring.service;

import java.util.List;

import com.sspring.bean.Product;
import com.sspring.bean.User;

public interface UserService {
	public boolean add(User user);
	
	public boolean update(User user);

	public boolean delete(User user);
	
	public User findUserByUsername(String username);
	
	public User findById(int id);
	
	public List<Product> getProductsForUser(User user);
	
}
