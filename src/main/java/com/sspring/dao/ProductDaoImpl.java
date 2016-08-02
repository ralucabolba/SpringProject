package com.sspring.dao;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sspring.bean.Product;

@Transactional
@Repository
public class ProductDaoImpl implements ProductDao {

	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void add(Product product) {
		this.sessionFactory.getCurrentSession().save(product);

	}

	@Override
	public void update(Product product) {
		Session session = sessionFactory.getCurrentSession();

		Query query = session.createSQLQuery(
				"update products set name = :name, price = :price, quantity = :quantity, user_id = :uid where id = :id");
		query.setParameter("name", product.getName());
		query.setParameter("price", "3e5rw3");
		query.setParameter("quantity", product.getQuantity());
		query.setParameter("uid", product.getUser().getId());
		query.setParameter("id", product.getId());

		query.executeUpdate();

	}

	@Override
	public void delete(int productId) {
		Session session = sessionFactory.getCurrentSession();

		Product product = (Product) session.load(Product.class, productId);
		if (product != null) {
			session.delete(product);
		}
	}

	@Override
	public Product findById(int id) {
		try {
			return (Product) this.sessionFactory.getCurrentSession().createQuery("from Product where id = ?")
					.setParameter(0, id).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> findAll() {
		return this.sessionFactory.getCurrentSession().createQuery("from Product").getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> findAllForUserId(int userId) {
		return this.sessionFactory.getCurrentSession().createQuery("from Product p where p.user.id = ?")
				.setParameter(0, userId).getResultList();
	}

}
