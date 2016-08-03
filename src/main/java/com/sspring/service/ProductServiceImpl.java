package com.sspring.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sspring.bean.Product;
import com.sspring.bean.User;
import com.sspring.dao.ProductDao;
import com.sspring.dao.UserDao;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private UserDao userDao;

	@Autowired
	private ProductDao productDao;

	@Override
	@Transactional
	public void add(Product product, User user) {
		user.setLastAction(new Date());
		userDao.update(user);
		productDao.persist(product);
	}

	@Override
	@Transactional(rollbackFor = RuntimeException.class)
	public void update(Product product, User user) {
		user.setLastAction(new Date());
		userDao.update(user);
		productDao.update(product);
	}

	@Override
	@Transactional
	public void delete(int productId, User user) {
		user.setLastAction(new Date());
		userDao.update(user);
		productDao.delete(productId);
	}

	@Override
	public Product findById(int productId) {
		return productDao.findById(productId);
	}

	@Override
	public List<Product> findAll() {
		return productDao.findAll();
	}

}
