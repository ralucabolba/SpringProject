package com.sspring.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.stream.Collectors;

import com.sspring.bean.User;
import com.sspring.dto.UserDto;

/**
 * Converter class from User hibernate entity to DTO
 * 
 * @author ralucab
 *
 */
public final class UserDtoConverter {
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
	
	public static UserDto toDto(User user){
		UserDto userDto = new UserDto();
		
		userDto.setId(user.getId());
		userDto.setName(user.getName());
		userDto.setUsername(user.getUsername());
		userDto.setPassword(user.getPassword());
		userDto.setAge(user.getAge());
		userDto.setSalary(user.getSalary());
		userDto.setLastAction(dateFormat.format(user.getLastAction()));
		userDto.setRole(RoleDtoConverter.toDto(user.getRole()));
		userDto.setProducts(user.getProducts()
				.stream()
				.map(ProductDtoConverter::toDto)
				.collect(Collectors.toList()));
		
		return userDto;
	}
	
	public static User toEntity(UserDto userDto){
		User user = new User();
		
		user.setId(userDto.getId());
		user.setName(userDto.getName());
		user.setUsername(userDto.getUsername());
		user.setPassword(userDto.getPassword());
		user.setAge(userDto.getAge());
		user.setSalary(userDto.getSalary());
		
		try {
			Date date = dateFormat.parse(userDto.getLastAction());
			user.setLastAction(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		user.setRole(RoleDtoConverter.toEntity(userDto.getRole()));
		user.setProducts(userDto.getProducts()
				.stream()
				.map(productDto -> ProductDtoConverter.toEntity(productDto, user))
				.collect(Collectors.toList()));
		
		return user;
	}
}
