package com.model;

public class Item {
	
	private int product_id;
	private int quantity;
	private int unit_cost;
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getUnit_cost() {
		return unit_cost;
	}
	public void setUnit_cost(int unit_cost) {
		this.unit_cost = unit_cost;
	}
	
	@Override
	public String toString() {
		return "Item [product_id=" + product_id + ", quantity=" + quantity + ", unit_cost=" + unit_cost + "]";
	}

}
