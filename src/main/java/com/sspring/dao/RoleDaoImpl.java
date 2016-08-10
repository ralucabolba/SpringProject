package com.sspring.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sspring.bean.Role;

/**
 * Concrete dao class for Role class
 * @author ralucab
 *
 */
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
		return (Role) getSession()
				.getNamedQuery("FIND_ROLE_BY_ROLE")
				.setParameter("role", role)
				.getSingleResult();
				/*.createCriteria(Role.class)
				.add(Restrictions.eq("role", role))
				.uniqueResult();*/
	}

}
