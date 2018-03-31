package com.model;

import java.util.List;

public class Cart {

	private List<Item> cart_items;

	public List<Item> getItems() {
		return cart_items;
	}

	public void setItems(List<Item> cart_items) {
		this.cart_items = cart_items;
	}

	@Override
	public String toString() {
		return "Cart [items=" + cart_items + "]";
	}

}
