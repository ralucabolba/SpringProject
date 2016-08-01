package com.sspring.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sspring.bean.Role;

@Repository
public class RoleDaoImpl implements RoleDao {

	@Override
	public boolean add(Role role) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Role role) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Role role) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Role findByRole(String role) {
		// TODO Auto-generated method stub
		return null;
	}
	/*private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public boolean add(Role role) {
		Session session = this.sessionFactory.openSession();
		session.beginTransaction();

		session.save(role);
		session.getTransaction().commit();

		session.close();

		return true;
	}

	@Override
	public boolean update(Role role) {
		Session session = this.sessionFactory.openSession();
		session.beginTransaction();

		session.update(role);
		session.getTransaction().commit();

		session.close();

		return true;
	}

	@Override
	public boolean delete(Role role) {
		Session session = this.sessionFactory.openSession();
		session.beginTransaction();

		session.delete(role);
		session.getTransaction().commit();

		session.close();

		return true;
	}

	@Override
	public Role findByRole(String role) {
		Session session = this.sessionFactory.openSession();
		session.beginTransaction();

		Criteria criteria = session.createCriteria(Role.class);
		Role r = (Role) criteria.add(Restrictions.eq("role", role)).uniqueResult();

		session.close();

		return r;
	}*/

}
