package com.jumplus.ecommerce.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.jumplus.ecommerce.daoimp.ItemDAOimp;
import com.jumplus.ecommerce.model.Item;

class ItemDAOTest {
	
	private ItemDAO  dao;
	
	@Test
	void testaddItem() {
		dao = new ItemDAOimp();
		
		Item item = new Item();
		boolean result = dao.addItem(item);
		
		assertTrue(result);
	}
	
	@Test
	void testgetItem() {
		dao = new ItemDAOimp();
		
		Item item = dao.getItem(0);
		assertNotNull(item);		
	}
	
	@Test
	void testgetAllItems() {
		dao = new ItemDAOimp();
		
		List<Item> itemList = dao.getAllItems();
		assertTrue(!itemList.isEmpty());
	}

}
