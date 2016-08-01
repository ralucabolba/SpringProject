package com.sspring.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Repository;

import com.sspring.bean.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Override
	public boolean add(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findUserByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	/*private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public boolean add(User user) {

		Session session = this.sessionFactory.openSession();
		session.beginTransaction();

		user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
		session.save(user);
		session.getTransaction().commit();

		session.close();
		return true;
	}

	@Override
	public boolean update(User user) {

		Session session = this.sessionFactory.openSession();
		session.beginTransaction();

		session.update(user);
		session.getTransaction().commit();

		session.close();
		return true;
	}

	@Override
	public boolean delete(User user) {

		Session session = this.sessionFactory.openSession();
		session.beginTransaction();

		session.delete(user);
		session.getTransaction().commit();

		session.close();
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public User findById(int id) {

		Session session = this.sessionFactory.openSession();
		User user = session.get(User.class, id);
		session.close();

		return user;
	}

	@SuppressWarnings("unchecked")
	@Override
	public User findUserByUsername(String username) {
		Session session = sessionFactory.openSession();
		
		Criteria criteria = session.createCriteria(User.class);
		User user = (User) criteria.add(Restrictions.eq("username", username)).uniqueResult();
		return user;
	}
*/
}
