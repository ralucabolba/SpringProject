package com.sspring.service;

import com.sspring.dto.UserDto;

public interface UserService {
	public void add(UserDto user);
	
	public void update(UserDto user);

	public void delete(UserDto user);
	
	public UserDto findUserByUsername(String username);
	
	public UserDto findById(int id);
	
	/*public List<Product> getProductsForUser(User user);*/
	
}
