package com.sspring.dao;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sspring.bean.Product;

/**
 * Concrete dao class for Product class
 * @author ralucab
 *
 */
@Transactional
@Repository
public class ProductDaoImpl implements ProductDao {

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void persist(Product product) {
		this.getSession().persist(product);
	}
	
	@Override
	public void update(Product product) {
		this.getSession().update(product);

	}

	@Override
	public void delete(int productId) {
		Product product = (Product) this.getSession().load(Product.class, productId);
		if (product != null) {
			this.getSession().delete(product);
		}
	}
	
	@Override
	public Product findById(int id) {
		try {
			return (Product) getSession()
					.createCriteria(Product.class)
					.add(Restrictions.eq("id", id))
					.uniqueResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> findAll() {
        return (List<Product>) getSession()
        		.createCriteria(Product.class)
        		.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> findAllForUserId(int userId) {
		return (List<Product>) getSession()
				.createCriteria(Product.class)
				.add(Restrictions.eq("user.id", userId))
				.list();
	}
}
