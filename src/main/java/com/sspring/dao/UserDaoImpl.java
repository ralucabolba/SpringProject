package com.sspring.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Repository;

import com.sspring.bean.User;
import com.sspring.mapper.UserMapper;

@Repository
public class UserDaoImpl implements UserDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public boolean add(User user) {
		int noRows = this.jdbcTemplate
				.update("insert into users(name_user, username, password, age, salary, last_action, role_id) values (?, ?, ?, ?, ?, ?, ?)",
						new Object[] { 
								user.getName(), 
								user.getUsername(),
								BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()), 
								user.getAge(), 
								user.getSalary(),
								user.getLastAction(), 
								user.getRole().getId() });

		if (noRows > 0) {
			return true;
		}

		return false;
	}
	
	@Override
	public boolean update(User user) {
		int noRows = this.jdbcTemplate.update(
				"update users set name_user = ?, username = ?, password = ?, age = ?, salary = ?, last_action = ?, role_id = ? where id = ?",
				new Object[] { 
						user.getName(), 
						user.getUsername(), 
						user.getPassword(), 
						user.getAge(), 
						user.getSalary(),
						user.getLastAction(), 
						user.getRole().getId(), 
						user.getId() });
		if (noRows > 0) {
			return true;
		}

		return false;
	}

	@Override
	public boolean delete(User user) {
		int noRows = this.jdbcTemplate.update("delete from users where id = ?", new Object[] { user.getId() });

		if (noRows > 0) {
			return true;
		}

		return false;
	}


	@SuppressWarnings("unchecked")
	@Override
	public User findById(int id) {
		try {
			return (User) this.jdbcTemplate.queryForObject("select * from users "
					+ "inner join roles on users.role_id = roles.id "
					+ "where users.id = ?", new Object[] { id }, userMapper);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public User findUserByUsername(String username) {
		try {
			return (User) this.jdbcTemplate.queryForObject("select * from users "
					+ "inner join roles on users.role_id = roles.id "
					+ "where users.username = ?",
					new Object[] { username }, userMapper);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}
	
}
