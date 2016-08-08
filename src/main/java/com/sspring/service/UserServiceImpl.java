package com.sspring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sspring.bean.Role;
import com.sspring.bean.User;
import com.sspring.converter.UserDtoConverter;
import com.sspring.dao.RoleDao;
import com.sspring.dao.UserDao;
import com.sspring.dto.UserDto;

/**
 * Concrete service class for operations performed on users
 * 
 * @author ralucab
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private RoleDao roleDao;

	@Autowired
	private UserDao userDao;

	@Override
	public void add(UserDto userDto) {
		/* Get the Role object for ROLE_USER */
		Role role = roleDao.findByRole("ROLE_USER");

		User user = UserDtoConverter.toEntity(userDto);

		user.setRole(role);
		userDao.persist(user);
	}

	@Override
	public void update(UserDto userDto) {
		userDao.update(UserDtoConverter.toEntity(userDto));
	}

	@Override
	public void delete(UserDto userDto) {
		userDao.delete(UserDtoConverter.toEntity(userDto));
	}

	@Override
	public UserDto findUserByUsername(String username) {
		return UserDtoConverter.toDto(userDao.findUserByUsername(username));
	}

	@Override
	public UserDto findById(int id) {
		return UserDtoConverter.toDto(userDao.findById(id));
	}

}
