package com.sspring.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sspring.bean.User;
import com.sspring.converter.RoleDtoConverter;
import com.sspring.converter.UserDtoConverter;
import com.sspring.dao.RoleDao;
import com.sspring.dao.UserDao;
import com.sspring.dto.ProductDto;
import com.sspring.dto.RoleDto;
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
		RoleDto role = RoleDtoConverter.toDto(roleDao.findByRole("ROLE_USER"));
		List<ProductDto> products = new ArrayList<>();
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
		
		userDto.setLastAction(dateFormat.format(new Date()));
		userDto.setProducts(products);
		userDto.setRole(role);
		
		User user = UserDtoConverter.toEntity(userDto);

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
		User user = userDao.findUserByUsername(username);
		if(user == null){
			return null;
		}
		return UserDtoConverter.toDto(user);
	}

	@Override
	public UserDto findById(int id) {
		User user = userDao.findById(id);
		if(user == null){
			return null;
		}
		return UserDtoConverter.toDto(user);
	}

}
