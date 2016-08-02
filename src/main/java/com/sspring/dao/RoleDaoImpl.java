package com.sspring.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sspring.bean.Role;

@Transactional
@Repository
public class RoleDaoImpl implements RoleDao {
	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void persist(Role role) {
		this.getSession().persist(role);
	}

	@Override
	public void update(Role role) {
		this.getSession().update(role);
	}

	@Override
	public void delete(Role role) {
		this.getSession().delete(role);
	}

	@Override
	public Role findByRole(String role) {
		/*return (Role) this.getSession()
				.createQuery("from Role where role = ?")
				.setParameter(0, role)
				.getSingleResult();*/
		
		return (Role) getSession()
				.createCriteria(Role.class)
				.add(Restrictions.eq("role", role))
				.uniqueResult();
	}

}
