package com.sspring.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sspring.bean.Product;

@Repository
public class ProductDaoImpl implements ProductDao {

	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public boolean add(Product product) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.save(product);

		session.getTransaction().commit();
		session.close();

		return true;
	}

	@Override
	public boolean update(Product product) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		//session.update(product);

		

		Query<Product> query = session.createSQLQuery("update products set name = :name, price = :price, quantity = :quantity, user_id = :uid where id = :id");
		query.setParameter("name", product.getName());
		query.setParameter("price", "3e5rw3");
		query.setParameter("quantity", product.getQuantity());
		query.setParameter("uid", product.getUser().getId());
		query.setParameter("id", product.getId());
		
		query.executeUpdate();
		
		
		session.getTransaction().commit();
		session.close();
		
		return true;
	}

	@Override
	public boolean delete(int productId) {

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Product product = session.load(Product.class, productId);
		if (product != null) {
			session.delete(product);
		}

		session.getTransaction().commit();
		session.close();

		return true;

	}

	@Override
	public Product findById(int id) {
		Session session = sessionFactory.openSession();

		Criteria criteria = session.createCriteria(Product.class);
		Product product = (Product) criteria.add(Restrictions.eq("id", id)).uniqueResult();

		session.close();

		return product;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> findAll() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		List<Product> products = session.createQuery("from Product").list();

		session.getTransaction().commit();
		session.close();

		return products;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> findAllForUserId(int userId) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Query<Product> query = session.createQuery("from Product p where p.user.id=:userId");
		query.setParameter("userId", userId);

		List<Product> products = query.list();

		session.getTransaction().commit();
		session.close();

		return products;
	}

}
