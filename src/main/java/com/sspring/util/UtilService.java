package com.sspring.util;

import org.springframework.context.MessageSource;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

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

}
