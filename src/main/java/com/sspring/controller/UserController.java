package com.sspring.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.sspring.dto.ProductDto;
import com.sspring.dto.UserDto;
import com.sspring.service.ProductService;
import com.sspring.service.UserService;

/**
 * Controller class for operations on users
 * @author ralucab
 *
 */
@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private ProductService productService;

	/* Redirection to login page */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView firstPage() {
		ModelAndView model = new ModelAndView();
		model.setViewName("login");
		return model;
	}

	/* Redirection to signup page */
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public ModelAndView signupPage() {
		ModelAndView model = new ModelAndView();
		model.setViewName("signup");
		return model;
	}

	
	@RequestMapping(value = "/signup", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void signup(@RequestBody UserDto userDto, HttpServletResponse response) throws IOException {
		Map<String, Object> map = new HashMap<>();
		
		boolean isValid = false;
		
		if(userService.findUserByUsername(userDto.getUsername()) != null){
			map.put("error", "The username already exists in database");
		}
		else{
			isValid = true;
			userService.add(userDto);
			map.put("url", "login.jsp");
		}

		map.put("isValid", isValid);
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(new Gson().toJson(map));
	}

	@RequestMapping(value = "/success", method = RequestMethod.GET)
	public ModelAndView successPage() {
		ModelAndView model = new ModelAndView();

		/* Get the authenticated user*/ 
		UserDto userDto = userService.findUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
		String role = getUserRole(userDto.getRole().getRole());

		List<ProductDto> products;
		
		if(role.equals("admin")){
			products = productService.findAll();
		}
		else{
			products = userDto.getProducts();
		}

		model.addObject("productList", products);
		model.addObject("role", role);
		model.addObject("lastAction", userDto.getLastAction());
		model.setViewName("success");
		return model;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView submitLogin(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {
		ModelAndView model = new ModelAndView();

		if (error != null) {
			model.addObject("errorMessage", "Invalid username or password");
		}

		if (logout != null) {
			model.addObject("logoutMessage", "Logged out successfully");
		}

		model.setViewName("login");

		return model;
	}

	/**
	 * Method which returns the role of an user, e.g. for 'ROLE_USER' it returns
	 * 'user'
	 * 
	 * @param role
	 * @return a String which represents the role of an user
	 */
	private String getUserRole(String role) {
		if ("ROLE_USER".equals(role)) {
			return "user";
		} else if ("ROLE_ADMIN".equals(role)) {
			return "admin";
		}

		return null;
	}

}
