package com.sspring.service;

import java.util.List;

import com.sspring.dto.ProductDto;
import com.sspring.dto.UserDto;

public interface ProductService {
	public void add(ProductDto productDto, UserDto userDto);

	public void update(ProductDto productDto, UserDto ownerDto, UserDto authenticatedUserDto);

	public void delete(int productId, UserDto userDto);
	
	public ProductDto findById(int productId);
	
	public List<ProductDto> findAll();

	public List<ProductDto> findAllForUserId(int userId);
}
