package com.sspring.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.sspring.bean.Role;
import com.sspring.bean.User;

/**
 * Mapper class for an User object. It maps the table 'users' from database to
 * the in-memory objects
 * 
 * @author ralucab
 *
 */
@Component
public final class UserMapper implements RowMapper {
	@Autowired
	private RoleMapper roleMapper;
	
	@Override
	public User mapRow(ResultSet rs, int rowNo) throws SQLException {
		User user = new User();
		Role role = roleMapper.mapRow(rs, rowNo);

		user.setId(rs.getInt("users.id"));
		user.setName(rs.getString("users.name_user"));
		user.setUsername(rs.getString("users.username"));
		user.setPassword(rs.getString("users.password"));
		user.setAge(rs.getInt("users.age"));
		user.setSalary(rs.getDouble("users.salary"));
		user.setLastAction(rs.getTimestamp("users.last_action"));
		user.setRole(role);

		return user;
	}

}
