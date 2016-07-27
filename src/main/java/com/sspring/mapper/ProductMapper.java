package com.sspring.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.sspring.bean.Product;
import com.sspring.bean.User;

/**
 * Mapper class for Product objects. It maps the table 'products' from database
 * to the in-memory objects
 * 
 * @author ralucab
 *
 */

@Component
public class ProductMapper implements RowMapper {
	@Autowired
	private UserMapper userMapper;

	@Override
	public Product mapRow(ResultSet rs, int rowNo) throws SQLException {
		Product product = new Product();
		User user = userMapper.mapRow(rs, rowNo); // make use of the
													// mapper class for User

		product.setId(rs.getInt("products.id"));
		product.setName(rs.getString("products.name"));
		product.setPrice(rs.getDouble("products.price"));
		product.setQuantity(rs.getInt("products.quantity"));
		product.setUser(user);

		return product;
	}

}
