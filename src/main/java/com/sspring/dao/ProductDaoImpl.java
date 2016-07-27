package com.sspring.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sspring.bean.Product;
import com.sspring.mapper.ProductMapper;

@Repository
public class ProductDaoImpl implements ProductDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	private ProductMapper productMapper;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public boolean add(Product product) {
		int noRows = this.jdbcTemplate
				.update("insert into products(name, price, quantity, user_id) values (?, ?, ?, ?)", new Object[] {
						product.getName(), product.getPrice(), product.getQuantity(), product.getUser().getId() });

		if (noRows > 0) {
			return true;
		}

		return false;
	}

	@Override
	public boolean update(Product product) {
		int noRows = this.jdbcTemplate.update(
				"update products set name = ?, price = ?, quantity = ?, user_id = ? where id = ?",
				new Object[] { product.getName(), product.getPrice(), product.getQuantity(), product.getUser().getId(),
						product.getId() });

		if (noRows > 0) {
			return true;
		}

		return false;
	}

	@Override
	public boolean delete(int productId) {

		int noRows = this.jdbcTemplate.update("delete from products where id = ?", new Object[] { productId });

		if (noRows > 0) {
			return true;
		}

		return false;

	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Product findById(int id) {
		try {
			return (Product) this.jdbcTemplate.queryForObject(
					"select * from products "
					+ "inner join users on products.user_id = users.id "
					+ "inner join roles on users.role_id = roles.id "
					+ "where products.id = ?",
					new Object[] { id }, productMapper);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> findAll() {
		return this.jdbcTemplate.query("select * from products "
				+ "inner join users on products.user_id = users.id "
				+ "inner join roles on users.role_id = roles.id",
				productMapper);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> findAllForUserId(int userId) {
		return this.jdbcTemplate.query(
				"select * from products "
				+ "inner join users on products.user_id = users.id "
				+ "inner join roles on users.role_id = roles.id "
				+ "where user_id = ?",
				new Object[] { userId }, productMapper);
	}


}
