package com.troublord.Entity;

import javax.persistence.Entity;

public class ShipmentProduct {
// this entity only contains target product name price total etc...
	
	private String productName;

	private int price;
	
	
	public ShipmentProduct() {
		
	}

	public ShipmentProduct(String productName, int price) {
		this.productName = productName;
		this.price = price;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}



	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "ProductSimplified [productName=" + productName + ", price=" + price
				+  "]";
	}
	

	
	
}
