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

import com.sspring.bean.User;

@Transactional
@Repository
public class UserDaoImpl implements UserDao {

	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void add(User user) {
		user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
		this.sessionFactory.getCurrentSession().save(user);
	}

	@Override
	public void update(User user) {
		this.sessionFactory.getCurrentSession().update(user);
	}

	@Override
	public void delete(User user) {
		this.sessionFactory.getCurrentSession().delete(user);
	}

	@Override
	public User findById(int id) {
		try {
			return this.sessionFactory.getCurrentSession().get(User.class, id);
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public User findUserByUsername(String username) {
		/*
		 * Session session = sessionFactory.getCurrentSession(); //
		 * session.beginTransaction();
		 * 
		 * Criteria criteria = session.createCriteria(User.class); User user =
		 * (User) criteria.add(Restrictions.eq("username",
		 * username)).uniqueResult(); return user;
		 */
		try {
			return (User) this.sessionFactory.getCurrentSession().createQuery("from User where username = ?")
					.setParameter(0, username).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

}
