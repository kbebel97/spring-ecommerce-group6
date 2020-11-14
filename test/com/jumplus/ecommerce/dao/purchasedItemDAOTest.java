package com.jumplus.ecommerce.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.jumplus.ecommerce.daoimp.purchasedItemDAOimp;
import com.jumplus.ecommerce.model.purchasedItem;

class purchasedItemDAOTest {
	
	@Autowired 
	purchasedItemDAO purchasedItemDAO;

	@Test
	void testgetAllpurchasedItems() {
		purchasedItemDAO = new purchasedItemDAOimp();
		
		List<purchasedItem> purchasedItems = purchasedItemDAO.getAllpurchasedItems();
		assertTrue(!purchasedItems.isEmpty());
	}
	
	@Test
	void testgetpurchasedItems() {
		purchasedItemDAO = new purchasedItemDAOimp();
		
		List<purchasedItem> purchasedItems = purchasedItemDAO.getpurchasedItems(0);
		assertTrue(!purchasedItems.isEmpty());
	}
	
	@Test
	void testaddpurchasedItem() {
		purchasedItemDAO = new purchasedItemDAOimp();
		
		
		purchasedItem purchasedItem = new purchasedItem();
		boolean test = purchasedItemDAO.addpurchasedItem(purchasedItem);
		assertTrue(test);
	}
	
	@Test
	void deletepurchasedItem() {
		purchasedItemDAO = new purchasedItemDAOimp();
		boolean test = purchasedItemDAO.deletepurchasedItem(0, 0);
		assertTrue(test);
	}
	

}
