package com.sspring.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.sspring.dao.UserDao;
import com.sspring.dto.UserDto;

/**
 * Validator class for User class
 * @author ralucab
 *
 */
@Component
public class UserValidator implements Validator {
	@Autowired
	private UserDao userDao;

	@Override
	public boolean supports(Class<?> clazz) {
		return UserDto.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		UserDto user = (UserDto) target;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "Empty");
		if (!user.getName().matches("[a-zA-Z- ]*")) {
			errors.rejectValue("name", "NotMatch.registration.name");
		}

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "Empty");
		if (userDao.findUserByUsername(user.getUsername()) != null) {
			errors.rejectValue("username", "Duplicate.registration.username");
		}

		if (user.getUsername().length() < 6 || user.getUsername().length() > 32) {
			errors.rejectValue("username", "Size.registration.username");
		}

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "Empty");
		if (user.getPassword().length() < 6 || user.getPassword().length() > 32) {
			errors.rejectValue("password", "Size.registration.password");
		}

		if (!user.getPassword().equals(user.getConfirmationPassword())) {
			errors.rejectValue("confirmationPassword", "Different.registration.confirmationPassword");
		}
	}

}
