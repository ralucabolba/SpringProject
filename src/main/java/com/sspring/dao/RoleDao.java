package com.sspring.dao;

import com.sspring.bean.Role;

public interface RoleDao {
	public void add(Role role);

	public void update(Role role);

	public void delete(Role role);
	
	public Role findByRole(String role);
}
