package com.jumplus.ecommerce.dao;

import java.util.List;

import com.jumplus.ecommerce.model.User;
import com.jumplus.ecommerce.model.User.ROLE;

public interface UserDAO {
	  public List<User> getAllUsers();
		
		public User getUserByUsername(String username);
		
		public User getUserByPassword(String password);
		
		public User getUserByEmail(String email);
		public List<User> getUserByRole(ROLE role);
		
		public boolean addUser(User user);
		
		public boolean updateUser(User user);
		
		public boolean deleteUser(User user);
	}

