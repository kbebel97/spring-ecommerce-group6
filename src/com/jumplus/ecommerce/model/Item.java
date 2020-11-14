package com.jumplus.ecommerce.model;

public class Item {

	private int itemId;
	private String name;
	private String code;
	private double price;
	
	public Item() {
		this(0, "N/A", "N/A", 0.00);
	}

	public Item(int itemId, String name, String code, double price) {
		super();
		this.itemId = itemId;
		this.name = name;
		this.code = code;
		this.price = price;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", name=" + name + ", code=" + code + ", price=" + price + "]";
	}

	

}
