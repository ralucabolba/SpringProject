package com.sspring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sspring.bean.Product;
import com.sspring.bean.User;
import com.sspring.service.ProductService;
import com.sspring.service.UserService;
import com.sspring.util.UtilService;
import com.sspring.validator.UserValidator;

@Controller
public class UserController {

	@Autowired
	private UserValidator userValidator;

	@Autowired
	private MessageSource messageSource;

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

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public ModelAndView signup(@ModelAttribute("user") User user, BindingResult result) {
		ModelAndView model = new ModelAndView();

		userValidator.validate(user, result);

		if (result.hasErrors()) {
			String error = UtilService.getError(result, messageSource);

			model.addObject("signUpError", error);
			model.setViewName("signup");
			return model;
		}

		userService.add(user);

		model.setViewName("redirect:/login");
		return model;
	}

	@RequestMapping(value = "/success", method = RequestMethod.GET)
	public ModelAndView successPage() {
		ModelAndView model = new ModelAndView();

		/* Get the authenticated user */
		User user = userService.findUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
		String role = getUserRole(user.getRole().getRole());

		List<Product> products;
		
		if(role.equals("admin")){
			products = productService.findAll();
		}
		else{
			products = user.getProducts();
		}

		model.addObject("productList", products);
		model.addObject("role", role);
		model.addObject("lastAction", user.getLastAction());
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
