package com.sspring.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Bean class product representing an ordinary product, with price and quantity
 * attributes
 * 
 * @author ralucab
 *
 */

@Entity
@Table(name = "products")
@NamedQueries({ 
	@NamedQuery(name = "FIND_ALL_PRODUCTS", 
				query = "from Product"),
	@NamedQuery(name = "FIND_ALL_PRODUCTS_FOR_USER", 
				query = "from Product where user.id = :userId") })
public class Product implements Serializable {
	private static final long serialVersionUID = -1079322051204927830L;

	@Id
	@GeneratedValue
	private int id;
	private String name;
	private double price;
	private int quantity;

	@ManyToOne
	@JoinColumn(name = "user_id")
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
