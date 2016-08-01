package com.sspring.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sspring.bean.Product;
import com.sspring.bean.User;
import com.sspring.repository.ProductRepository;
import com.sspring.repository.UserRepository;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private UserRepository userDao;
	
	@Autowired
	private ProductRepository productDao;

	@Override
	@Transactional
	public void add(Product product, User user) {
		user.setLastAction(new Date());
		userDao.save(user);
		productDao.save(product);
	}

	@Override
	@Transactional
	public void update(Product product, User user) {
		user.setLastAction(new Date());
		userDao.save(user);
		productDao.save(product);
	}

	@Override
	@Transactional
	public void delete(Product product, User user) {
		user.setLastAction(new Date());
		userDao.save(user);
		productDao.delete(product);
	}

	@Override
	public Product findById(int productId) {
		return productDao.findById(productId);
	}

	@Override
	public List<Product> findAll() {
		return productDao.findAll();
	}

	@Override
	public List<Product> findAllForUserId(int userId) {
		return productDao.findAllByUserId(userId);
	}
	
	
}
