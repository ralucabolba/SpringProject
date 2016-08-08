package com.sspring.dto;

import java.io.Serializable;
import java.util.List;

/**
 * Data Transfer Object for users
 * @author ralucab
 *
 */
public class UserDto implements Serializable {
	private static final long serialVersionUID = -7130738276942449402L;

	private int id;
	private String name;
	private String username;
	private String password;
	private String confirmationPassword;
	private int age;
	private double salary;
	private String lastAction;
	private List<ProductDto> products;
	private RoleDto role;

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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmationPassword() {
		return confirmationPassword;
	}

	public void setConfirmationPassword(String confirmationPassword) {
		this.confirmationPassword = confirmationPassword;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getLastAction() {
		return lastAction;
	}

	public void setLastAction(String lastAction) {
		this.lastAction = lastAction;
	}

	public List<ProductDto> getProducts() {
		return products;
	}

	public void setProducts(List<ProductDto> products) {
		this.products = products;
	}

	public RoleDto getRole() {
		return role;
	}

	public void setRole(RoleDto role) {
		this.role = role;
	}

}
