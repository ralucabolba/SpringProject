package com.sspring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sspring.bean.Product;
import com.sspring.bean.Role;
import com.sspring.bean.User;
import com.sspring.repository.ProductRepository;
import com.sspring.repository.RoleRepository;
import com.sspring.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private RoleRepository roleDao;
	
	@Autowired
	private UserRepository userDao;
	
	@Autowired
	private ProductRepository productDao;
	
	@Override
	public boolean add(User user) {
		/*Get the Role object for ROLE_USER*/
		Role role = roleDao.findByRole("ROLE_USER");
		
		user.setRole(role);
		return (userDao.save(user) == null);
	}
	
	@Override
	public boolean update(User user) {
		userDao.save(user);
		return true;
	}

	@Override
	public boolean delete(User user) {
		userDao.delete(user);
		return true;
	}
	

	@Override
	public List<Product> getProductsForUser(User user) {
		List<Product> products = null;

		String role = user.getRole().getRole();
		
		if (role.equals("ROLE_ADMIN")) { // show all the products for the admin
			products = productDao.findAll();
		} else if (role.equals("ROLE_USER")) { // and for user only his/her products
			products = productDao.findAllByUserId(user.getId());
		}
		
		return products;
	}

	@Override
	public User findUserByUsername(String username) {
		return userDao.findByUsername(username);
	}

	@Override
	public User findById(int id) {
		return userDao.findById(id);
	}

	
	
}
