package com.sspring.dto;

import java.io.Serializable;

/**
 * Data Transfer Object for products
 * @author ralucab
 *
 */
public class ProductDto implements Serializable {
	private static final long serialVersionUID = 1659735610456017027L;

	private int id;
	private String name;
	private double price;
	private int quantity;
	private int userId;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}
