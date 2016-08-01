package com.sspring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sspring.bean.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	public Product save(Product product);

//	public void update(Product product);

	public void delete(Product product);

	public Product findById(int id);

	public List<Product> findAll();

	public List<Product> findAllByUserId(int id);

}
