package com.monisoni.netbanking.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/* TODO: change all the implementation where userId is used to use username */

@Entity
@Table(name = "user")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id", unique = true)
	private long userId;

	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	@Column(name = "name")
	private String name;

	@Column(name = "email")
	private String email;

	@Column(name = "mobile_no")
	private long mobileNo;

	@Column(name = "address")
	private String address;

	@Column(name = "enabled")
	private int enabled;

	public User() {
		
	}

	public User(User user) {
		this.userId = user.userId;
		this.username = user.username;
		this.password = user.password;
		this.name = user.name;
		this.email = user.email;
		this.mobileNo = user.mobileNo;
		this.address = user.address;
		this.enabled = user.enabled;
	}

	public String getAddress() {
		return address;
	}

	public String getEmail() {
		return email;
	}

	public int getEnabled() {
		return enabled;
	}

	public long getMobileNo() {
		return mobileNo;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public long getUserId() {
		return userId;
	}

	public String getUsername() {
		return username;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
