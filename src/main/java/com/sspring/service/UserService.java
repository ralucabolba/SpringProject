package com.sspring.service;

import java.util.List;

import com.sspring.bean.Product;
import com.sspring.bean.User;

public interface UserService {
	public void add(User user);
	
	public void update(User user);

	public void delete(User user);
	
	public User findUserByUsername(String username);
	
	public User findById(int id);
	
	public List<Product> getProductsForUser(User user);
	
}
