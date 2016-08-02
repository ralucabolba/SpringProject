package com.sspring.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sspring.bean.Role;
import com.sspring.bean.User;

@Transactional
@Repository
public class RoleDaoImpl implements RoleDao {
	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void add(Role role) {
		this.sessionFactory.getCurrentSession().save(role);
	}

	@Override
	public void update(Role role) {
		this.sessionFactory.getCurrentSession().update(role);
	}

	@Override
	public void delete(Role role) {
		this.sessionFactory.getCurrentSession().delete(role);
	}

	@Override
	public Role findByRole(String role) {
		/*Session session = this.sessionFactory.getCurrentSession();
		//session.beginTransaction();

		Criteria criteria = session.createCriteria(Role.class);
		Role r = (Role) criteria.add(Restrictions.eq("role", role)).uniqueResult();

		//session.close();

		return r;*/
		
		return (Role) this.sessionFactory.getCurrentSession()
				.createQuery("from Role where role = ?")
				.setParameter(0, role)
				.getSingleResult();
	}

}
