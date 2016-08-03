package com.sspring.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sspring.bean.Product;

@Transactional
@Repository
public class ProductDaoImpl implements ProductDao {

	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public void persist(Product product) {
		entityManager.persist(product);
	}
	
	@Override
	public void update(Product product) {
		entityManager.merge(product);
	}

	@Override
	public void delete(int productId) {
		Product product = entityManager.find(Product.class, productId);
		if (product != null) {
			entityManager.remove(product);
		}
	}
	
	@Override
	public Product findById(int id) {
		return entityManager.find(Product.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> findAll() {
        return entityManager.createQuery("from Product").getResultList();
	}
}
