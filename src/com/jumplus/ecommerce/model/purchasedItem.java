package com.jumplus.ecommerce.model;


public class purchasedItem extends cartItem {

	private String purchaseDate;

	
	public purchasedItem(){
		this(0, "N/A", "N/A","N/A", 0, "N/A", 0);
	}

	public purchasedItem(int itemId, String name, String code, String price, int userId, String purchaseDate, int quantity){
		super(itemId,name,code, price, userId, quantity);
		this.purchaseDate = purchaseDate;
	}

	public String getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	@Override
	public String toString() {
		return "purchasedItem [purchaseDate=" + purchaseDate + "]";
	}
	
	



	

}
