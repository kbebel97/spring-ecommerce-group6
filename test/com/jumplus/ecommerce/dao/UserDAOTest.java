package com.jumplus.ecommerce.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.jumplus.ecommerce.daoimp.UserDAOimp;
import com.jumplus.ecommerce.model.User;

class UserDAOTest {
	
	private UserDAO  dao;
	
	@Test
	void testSave() {
		dao = new UserDAOimp();
		
		User user = new User();
		boolean result = dao.addUser(user);
		
		assertTrue(result);
	}

	@Test
	void testUpdate() {
		dao = new UserDAOimp();

		User user = new User();
		user.setName("Kacper");
		boolean result = dao.updateUser(user);
		
		assertTrue(result);		
	}
	
	@Test
	void testGetUserByEmail() {
		dao = new UserDAOimp();
		
		User user = dao.getUserByEmail("N/A");
		assertNotNull(user);		
	}


	@Test
	void testgetUserByPassword() {
		dao = new UserDAOimp();
		
		User user = dao.getUserByPassword("N/A");
		assertNotNull(user);
	}

	@Test
	void testDelete() {
		dao = new UserDAOimp();
		User user = new User();
		boolean result = dao.deleteUser(user);
		assertTrue(result);
	}

	@Test
	void testList() {
		fail("Not yet implemented");
	}

}
