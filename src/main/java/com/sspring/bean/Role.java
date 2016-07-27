package com.sspring.bean;

import java.io.Serializable;

/**
 * Bean class representing the role an user can have
 * @author ralucab
 *
 */
public class Role implements Serializable {
	private static final long serialVersionUID = 7746197782283698989L;

	private int id;
	private String role;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
