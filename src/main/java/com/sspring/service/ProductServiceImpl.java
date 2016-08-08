package com.sspring.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sspring.bean.Product;
import com.sspring.bean.User;
import com.sspring.converter.ProductDtoConverter;
import com.sspring.converter.UserDtoConverter;
import com.sspring.dao.ProductDao;
import com.sspring.dao.UserDao;
import com.sspring.dto.ProductDto;
import com.sspring.dto.UserDto;

/**
 * Concrete service class for operations performed on products
 * 
 * @author ralucab
 *
 */
@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private UserDao userDao;

	@Autowired
	private ProductDao productDao;

	@Override
	@Transactional
	public void add(ProductDto productDto, UserDto userDto) {
		User user = UserDtoConverter.toEntity(userDto);
		Product product = ProductDtoConverter.toEntity(productDto, user);

		user.setLastAction(new Date());
		userDao.update(user);
		productDao.persist(product);
	}

	@Override
	@Transactional(rollbackFor = RuntimeException.class)
	public void update(ProductDto productDto, UserDto ownerDto, UserDto authenticatedUserDto) {
		User authenticatedUser = UserDtoConverter.toEntity(authenticatedUserDto);
		User owner = UserDtoConverter.toEntity(ownerDto);

		Product product = ProductDtoConverter.toEntity(productDto, owner);

		authenticatedUser.setLastAction(new Date());
		userDao.update(authenticatedUser);
		productDao.update(product);
	}

	@Override
	@Transactional
	public void delete(int productId, UserDto userDto) {
		User user = UserDtoConverter.toEntity(userDto);

		user.setLastAction(new Date());
		userDao.update(user);
		productDao.delete(productId);
	}

	@Override
	public ProductDto findById(int productId) {
		return ProductDtoConverter.toDto(productDao.findById(productId));
	}

	@Override
	public List<ProductDto> findAll() {
		return productDao.findAll().stream().map(ProductDtoConverter::toDto).collect(Collectors.toList());
	}

	@Override
	public List<ProductDto> findAllForUserId(int userId) {
		return productDao.findAllForUserId(userId).stream().map(ProductDtoConverter::toDto)
				.collect(Collectors.toList());
	}

}
