package com.sspring.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sspring.bean.Role;

@Transactional
@Repository
public class RoleDaoImpl implements RoleDao {
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void persist(Role role) {
		entityManager.persist(role);
	}

	@Override
	public void update(Role role) {
		entityManager.merge(role);
	}

	@Override
	public void delete(Role role) {
		entityManager.remove(role);
	}

	@Override
	public Role findByRole(String role) {
		return (Role) entityManager
				.createQuery("from Role where role = :role")
				.setParameter("role", role)
				.getSingleResult();
	}

}
