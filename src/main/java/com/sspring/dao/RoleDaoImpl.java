package com.sspring.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sspring.bean.Role;
import com.sspring.mapper.RoleMapper;

@Repository
public class RoleDaoImpl implements RoleDao {
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private RoleMapper roleMapper;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public boolean add(Role role) {
		int noRows = this.jdbcTemplate.update("insert into roles(role) values (?)", new Object[] { role.getRole() });

		if (noRows > 0) {
			return true;
		}

		return false;
	}

	@Override
	public boolean update(Role role) {
		int noRows = this.jdbcTemplate.update("update roles set role = ? where id = ?",
				new Object[] { role.getRole(), role.getId() });

		if (noRows > 0) {
			return true;
		}

		return false;
	}

	@Override
	public boolean delete(Role role) {
		int noRows = this.jdbcTemplate.update("delete from roles where id = ?", new Object[] { role.getId() });

		if (noRows > 0) {
			return true;
		}

		return false;
	}

	@Override
	public Role findByRole(String role) {
		try {
			return (Role) this.jdbcTemplate.queryForObject("select * from roles where role = ?", new Object[] { role },
					roleMapper);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

}
