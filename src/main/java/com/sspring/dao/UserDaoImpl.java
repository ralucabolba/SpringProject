package com.sspring.dao;

import javax.persistence.NoResultException;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sspring.bean.Product;
import com.sspring.bean.User;

/**
 * Concrete dao class for User class
 * @author ralucab
 *
 */
@Transactional
@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void persist(User user) {
		this.getSession().persist(user);
	}

	@Override
	public void update(User user) {
		this.getSession().update(user);
	}

	@Override
	public void delete(User user) {
		this.getSession().delete(user);
	}

	@Override
	public User findById(int id) {
		try {
			return this.getSession().get(User.class, id);
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public User findUserByUsername(String username) {
		try {
			return (User) getSession().createCriteria(User.class)
					.add(Restrictions.eq("username", username))
					.uniqueResult();
			
		} catch (NoResultException e) {
			return null;
		}
	}

}
