package com.jumplus.ecommerce.dao;


import java.util.List;

import com.jumplus.ecommerce.model.Item;

public interface ItemDAO {
	
	public List<Item> getAllItems();
	
	public Item getItem(int itemId);
	
	public boolean addItem(Item item);
}
