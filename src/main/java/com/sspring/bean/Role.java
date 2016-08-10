package com.sspring.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Bean class representing the role an user can have
 * 
 * @author ralucab
 *
 */
@Entity
@Table(name = "roles")
@NamedQuery(name="FIND_ROLE_BY_ROLE",query="from Role where role = :role")
public class Role implements Serializable {
	private static final long serialVersionUID = 7746197782283698989L;

	@Id
	@GeneratedValue
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
