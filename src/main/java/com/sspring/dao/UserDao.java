package com.sspring.dao;

import com.sspring.bean.User;

public interface UserDao {

	public void persist(User user);
	
	public void update(User user);

	public void delete(User user);

	public User findById(int id);

	public User findUserByUsername(String username);
}
