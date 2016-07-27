package com.sspring.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.sspring.bean.Product;

@Component
public class ProductValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return Product.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Product product = (Product)target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "Empty");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "Empty");
		if(product.getPrice() <= 0.0){
			errors.rejectValue("price", "Negative.addProduct.price");
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "quantity", "Empty");
		if(product.getQuantity() <= 0){
			errors.rejectValue("quantity", "Negative.addProduct.quantity");
		}
		
	}

}
