package com.sspring.util;

import org.springframework.context.MessageSource;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import com.sspring.bean.User;
import com.sspring.dao.UserDao;

public class UtilService {
	/**
	 * Method that gets all the errors from the BindingResult object and
	 * concatenates them
	 * 
	 * @param result
	 * @return a String representing an error
	 */
	public static String getError(BindingResult result, MessageSource messageSource) {
		String error = "";
		/* Take all errors and send them to front-end */
		for (Object object : result.getAllErrors()) {
			if (object instanceof FieldError) {
				FieldError fieldError = (FieldError) object;
				String message = messageSource.getMessage(fieldError, null);
				error += message;
			}
		}

		return error;
	}

//	/**
//	 * Method that gets the authenticated user
//	 * 
//	 * @return an object of type User
//	 */
//	public static User getAuthenticatedUser(UserDao userDao) {
//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//		User user = userDao.findUserByUsername(authentication.getName());
//		return user;
//	}
}
