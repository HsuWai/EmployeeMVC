package com.app.proj.backend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


/**
 * @author HsuWaiWaiTun
 *
 */
@Entity
public class UserRole {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_role_id",  nullable = false)
	private Integer userRoleId;

	@Column(name = "role", unique = false)
	private String role;
	
	@Column(name = "description")
	private String description;

	public UserRole() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserRole(String role, String description) {
		super();
		this.role = role;
		this.description = description;
	}

	public UserRole(Integer userRoleId, String role, String description) {
		super();
		this.userRoleId = userRoleId;
		this.role = role;
		this.description = description;
	}

	public Integer getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(Integer userRoleId) {
		this.userRoleId = userRoleId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "UserRole [userRoleId=" + userRoleId + ", role=" + role + ", description=" + description + "]";
	}
	
	
}
