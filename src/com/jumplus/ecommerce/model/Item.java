package com.jumplus.ecommerce.model;

public class Item {

	private int itemId;
	private String name;
	private String code;
	private String price;
	
	public Item() {
		this(0, "N/A", "N/A", "N/A");
	}

	public Item(int itemId, String name, String code, String price) {
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

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", name=" + name + ", code=" + code + ", price=" + price + "]";
	}

	

}
