package com.sspring.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.sspring.bean.Role;

/**
 * Mapper class for Role objects. It maps the table 'roles' from database to
 * the in-memory objects
 * 
 * @author ralucab
 *
 */
@Component
public final class RoleMapper implements RowMapper {

	@Override
	public Role mapRow(ResultSet rs, int rowNo) throws SQLException {
		Role role = new Role();

		role.setId(rs.getInt("roles.id"));
		role.setRole(rs.getString("roles.role"));

		return role;
	}

}
