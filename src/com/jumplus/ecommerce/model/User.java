package com.jumplus.ecommerce.model;

import java.util.ArrayList;
import java.util.List;

public class User {

	
	public enum ROLE{
		USER,ADMIN
	}
	
	public static int staticuserId = 0;
	
	private int userId; 
	private String username;
	private String name;
	private String password;
	private String email;
	private ROLE role;
	
	public User() {
		this(0, "N/A", "N/A", "N/A", "N/A", ROLE.USER);
	}
	
	
	public User(int userId, String username, String name, String password, String email, ROLE role) {
		super();
		this.userId = userId;
		this.username = username;
		this.name = name;
		this.password = password;
		this.email = email;
		this.role = role;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public ROLE getRole() {
		return role;
	}


	public void setRole(ROLE role) {
		this.role = role;
	}


	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", name=" + name + ", password=" + password
				+ ", email=" + email + ", role=" + role + "]";
	}

	
	

	
	
	
	
}

