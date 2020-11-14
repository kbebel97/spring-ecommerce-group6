package com.jumplus.ecommerce.dao;

import java.util.List;

import com.jumplus.ecommerce.model.cartItem;

public interface cartItemDAO {
	
	public List<cartItem> getAllcartItems();
	
	public List<cartItem> getcartItems(int userId);
	
	public boolean addcartItem(cartItem item);
	
	public boolean deletecartItem(int itemId, int userId);
	
	public boolean updatecartItemQuantity(cartItem cartItem);

}
