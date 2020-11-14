package com.jumplus.ecommerce.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.jumplus.ecommerce.daoimp.cartItemDAOimp;
import com.jumplus.ecommerce.model.cartItem;

class cartItemDAOTest {
	
	@Autowired 
	cartItemDAO cartItemDAO;

	@Test
	void testgetAllcartItems() {
		cartItemDAO = new cartItemDAOimp();
		
		List<cartItem> cartItems = cartItemDAO.getAllcartItems();
		assertTrue(!cartItems.isEmpty());
	}
	
	@Test
	void testgetcartItems() {
		cartItemDAO = new cartItemDAOimp();
		
		List<cartItem> cartItems = cartItemDAO.getcartItems(0);
		assertTrue(!cartItems.isEmpty());
	}
	
	@Test
	void testaddcartItem() {
		cartItemDAO = new cartItemDAOimp();
		cartItem cartItem = new cartItem();
		boolean test = cartItemDAO.addcartItem(cartItem);
		assertTrue(test);
	}
	
	@Test
	void deletecartItem() {
		cartItemDAO = new cartItemDAOimp();
		boolean test = cartItemDAO.deletecartItem(0, 0);
		assertTrue(test);
	}
	
	@Test
	void testupdatecartItemQuantity() {
		cartItemDAO = new cartItemDAOimp();
		cartItem cartItem = new cartItem();
		boolean test = cartItemDAO.updatecartItemQuantity(cartItem);
	}

}
