package com.monisoni.netbanking.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_roles")
public class UserRoles {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_role_id")
	private Long userroleid;

	/* TODO: Add one-to-many mapping annotation */
	@Column(name = "user_id")
	private Long userId;

	@Column(name = "role")
	private String role;

	public String getRole() {
		return role;
	}

	public Long getUserId() {
		return userId;
	}

	public Long getUserroleid() {
		return userroleid;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public void setUserroleid(Long userroleid) {
		this.userroleid = userroleid;
	}

	

}
