package com.jumplus.ecommerce.dao;

import java.util.List;

import com.jumplus.ecommerce.model.cartItem;
import com.jumplus.ecommerce.model.purchasedItem;

public interface purchasedItemDAO { 
	
	public List<purchasedItem> getAllpurchasedItems();
	
	public List<purchasedItem> getpurchasedItems(int userId);
	
	public boolean addpurchasedItem(purchasedItem purchasedItem);
	
	public boolean deletepurchasedItem(int itemId, int userId);

}
