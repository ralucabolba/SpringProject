package com.sspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sspring.bean.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	public Role save(Role role);

//	public void update(Role role);

	public void delete(Role role);

	public Role findByRole(String role);
}
