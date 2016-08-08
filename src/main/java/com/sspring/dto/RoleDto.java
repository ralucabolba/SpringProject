package com.sspring.dto;

import java.io.Serializable;

/**
 * Data Transfer Object for user roles
 * @author ralucab
 *
 */
public class RoleDto implements Serializable {
	private static final long serialVersionUID = -3997066051143866640L;

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
