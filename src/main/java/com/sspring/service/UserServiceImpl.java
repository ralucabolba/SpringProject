package com.sspring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sspring.bean.Product;
import com.sspring.bean.Role;
import com.sspring.bean.User;
import com.sspring.dao.ProductDao;
import com.sspring.dao.RoleDao;
import com.sspring.dao.UserDao;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private RoleDao roleDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private ProductDao productDao;
	
	@Override
	public void add(User user) {
		/*Get the Role object for ROLE_USER*/
		Role role = roleDao.findByRole("ROLE_USER");
		
		user.setRole(role);
		userDao.persist(user);
	}
	
	@Override
	public void update(User user) {
		userDao.update(user);
	}

	@Override
	public void delete(User user) {
		userDao.delete(user);
	}
	

	/*@Override
	public List<Product> getProductsForUser(User user) {
		List<Product> products = null;

		String role = user.getRole().getRole();
		
		if (role.equals("ROLE_ADMIN")) { // show all the products for the admin
			products = productDao.findAll();
		} else if (role.equals("ROLE_USER")) { // and for user only his/her products
			products = productDao.findAllForUserId(user.getId());
		}
		
		return products;
	}*/

	@Override
	public User findUserByUsername(String username) {
		return userDao.findUserByUsername(username);
	}

	@Override
	public User findById(int id) {
		return userDao.findById(id);
	}

	
	
}
