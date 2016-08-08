package com.sspring.converter;

import com.sspring.bean.Product;
import com.sspring.bean.User;
import com.sspring.dto.ProductDto;

/**
 * Converter class from Product hibernate entity to DTO class
 * 
 * @author ralucab
 *
 */
public final class ProductDtoConverter {
	public static ProductDto toDto(Product product) {
		ProductDto productDto = new ProductDto();

		productDto.setId(product.getId());
		productDto.setName(product.getName());
		productDto.setPrice(product.getPrice());
		productDto.setQuantity(product.getQuantity());
		productDto.setUserId(product.getUser().getId());

		return productDto;
	}

	/**
	 * Converts from DTO to hibernate entity
	 * 
	 * @param productDto
	 * @param user
	 *            needed since product has an attribute of object User and
	 *            productDto has only the user's id
	 * @return
	 */
	public static Product toEntity(ProductDto productDto, User user) {
		Product product = new Product();

		product.setId(productDto.getId());
		product.setName(productDto.getName());
		product.setPrice(productDto.getPrice());
		product.setQuantity(productDto.getQuantity());
		product.setUser(user);

		return product;
	}
}
