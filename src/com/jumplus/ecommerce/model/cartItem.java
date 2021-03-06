package com.jumplus.ecommerce.model;


public class cartItem extends Item {

	private int itemId;
	private String name;
	private String code;
	private String price;
	private int userId;
	private int quantity;
	
	public cartItem() {
		this(0, "N/A","N/A","N/A", 0, 0);
	}

	public cartItem(int itemId, String name, String code, String price, int userId, int quantity){
		super(itemId, name, code, price);
		this.itemId = itemId;
		this.name = name;
		this.userId = userId;
		this.quantity = quantity;
		this.name = name;
		this.code = code;
		this.price = price;
		
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "cartItem [itemId=" + itemId + ", userId=" + userId + ", quantity=" + quantity + "]";
	}

	

	

	
	
	

	
	

	
	
}
