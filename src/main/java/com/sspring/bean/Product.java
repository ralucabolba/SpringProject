package com.sspring.bean;

import java.io.Serializable;

/**
 * Bean class product representing an ordinary product, with price and quantity
 * attributes
 * 
 * @author ralucab
 *
 */
public class Product implements Serializable {
	private static final long serialVersionUID = -1079322051204927830L;

	private int id;
	private String name;
	private double price;
	private int quantity;
	private User user;

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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
