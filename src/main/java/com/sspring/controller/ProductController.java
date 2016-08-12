package com.sspring.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sspring.dto.ProductDto;
import com.sspring.dto.UserDto;
import com.sspring.service.ProductService;
import com.sspring.service.UserService;

/**
 * Controller class for operations on products
 * @author ralucab
 *
 */
@Controller
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/success/add", method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void addNewProduct(@RequestBody ProductDto productDto) {
		/*
		 * Get the authenticated user in order to update the activity field and
		 * to determine who created the product
		 */
		UserDto userDto = userService.findUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
		//productDto.setUser(userDto);

		try {
			productService.add(productDto, userDto);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/success/update", method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void updateProduct(@RequestBody ProductDto productDto) {
		/*Get the owner of the product*/
		
		UserDto owner = userService.findById(productDto.getUserId());
		
		/* Get the authenticated user in order to update the activity field */
		UserDto authenticatedUserDto = userService.findUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName());

		try {
			productService.update(productDto, owner, authenticatedUserDto);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/success/delete/{productId}", method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void deleteProductPage(@PathVariable int productId) {
		UserDto userDto = userService.findUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName());

		try {
			productService.delete(productId, userDto);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
