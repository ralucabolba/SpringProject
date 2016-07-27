package com.sspring.dao;

import com.sspring.bean.User;

public interface UserDao {

	public boolean add(User user);
	
	public boolean update(User user);

	public boolean delete(User user);

	public User findById(int id);

	public User findUserByUsername(String username);
}
