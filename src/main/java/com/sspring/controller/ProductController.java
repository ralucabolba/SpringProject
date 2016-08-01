package com.sspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sspring.bean.Product;
import com.sspring.bean.User;
import com.sspring.service.ProductService;
import com.sspring.service.UserService;
import com.sspring.util.UtilService;
import com.sspring.validator.ProductValidator;

@Controller
public class ProductController {
	@Autowired
	private ProductValidator productValidator;

	@Autowired
	private MessageSource messageSource;

	@Autowired
	private ProductService productService;
	
	@Autowired
	private UserService userService;

	/* Handle request for add product operation */
	@RequestMapping(value = "/success/add", method = RequestMethod.GET)
	public ModelAndView addProductPage() {
		ModelAndView model = new ModelAndView();
		model.setViewName("addProduct");
		return model;
	}

	@RequestMapping(value = "/success/add", method = RequestMethod.POST)
	public ModelAndView addNewProduct(@ModelAttribute Product product, BindingResult result, RedirectAttributes attr) {
		ModelAndView model = new ModelAndView();

		productValidator.validate(product, result);

		if (result.hasErrors()) {
			String error = UtilService.getError(result, messageSource);

			model.addObject("incorrectProductMessage", error);
			model.setViewName("addProduct");
			return model;
		}
		/*
		 * Get the authenticated user in order to update the activity field and
		 * to determine who created the product
		 */
		User user = userService.findUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
		product.setUser(user);

		try {
			productService.add(product, user);
		} catch (Exception e) {
			e.printStackTrace();

			model.addObject("incorrectProductMessage", "Could not add product. Please try again later.");
			model.setViewName("addProduct");
			return model;
		}

		model.setViewName("redirect:/success");

		return model;
	}

	@RequestMapping(value = "/success/update/{productId}", method = RequestMethod.GET)
	public ModelAndView updateProductPage(@PathVariable("productId") int productId) {
		ModelAndView model = new ModelAndView();
		model.setViewName("/updateProduct");

		Product product = productService.findById(productId);
		model.addObject("selectedProduct", product);
		return model;
	}

	@RequestMapping(value = "/success/update", method = RequestMethod.POST)
	public ModelAndView updateProduct(@ModelAttribute Product product, BindingResult result,
			@RequestParam("userId") int userId, RedirectAttributes attr) {
		ModelAndView model = new ModelAndView();

		productValidator.validate(product, result);

		if (result.hasErrors()) {
			String error = UtilService.getError(result, messageSource);

			attr.addFlashAttribute("incorrectProductMessage", error);
			model.setViewName("redirect:/success/update/" + product.getId());
			return model;
		}

		product.setUser(userService.findById(userId));

		/* Get the authenticated user in order to update the activity field */
		User user = userService.findUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName());

		try {
			productService.update(product, user);
		} catch (Exception e) {
			e.printStackTrace();

			attr.addFlashAttribute("incorrectProductMessage", "Could not update product. Please try again later.");
			model.setViewName("redirect:/success/update/" + product.getId());
			return model;
		}

		model.setViewName("redirect:/success");

		return model;
	}

	/* Handle request for delete product operation */
	@RequestMapping(value = "/success/delete", method = RequestMethod.POST)
	public ModelAndView deleteProductPage(@RequestParam("productId") int productId, RedirectAttributes attr) {
		ModelAndView model = new ModelAndView();

		/* Get the authenticated user in order to update the activity field */
		User user = userService.findUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
		Product product = productService.findById(productId);
		
		try {
			productService.delete(product, user);
		} catch (Exception e) {
			e.printStackTrace();

			attr.addFlashAttribute("incorrectProductMessage", "Could not delete product. Please try again later.");
			model.setViewName("redirect:/success");
			return model;
		}

		model.setViewName("redirect:/success");

		return model;
	}

}
