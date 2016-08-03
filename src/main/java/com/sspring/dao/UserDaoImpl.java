package com.sspring.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sspring.bean.User;

@Transactional
@Repository
public class UserDaoImpl implements UserDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void persist(User user) {
		entityManager.persist(user);
	}

	@Override
	public void update(User user) {
		entityManager.merge(user);
	}

	@Override
	public void delete(User user) {
		entityManager.remove(user);
	}

	@Override
	public User findById(int id) {
		return entityManager.find(User.class, id);
	}

	@Override
	public User findUserByUsername(String username) {
		return (User) entityManager
				.createQuery("from User where username = :username")
				.setParameter("username", username)
				.getSingleResult();
	}

}
