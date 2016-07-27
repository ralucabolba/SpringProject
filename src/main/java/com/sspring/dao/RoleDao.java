package com.sspring.dao;

import com.sspring.bean.Role;

public interface RoleDao {
	public boolean add(Role role);

	public boolean update(Role role);

	public boolean delete(Role role);
	
	public Role findByRole(String role);
}
