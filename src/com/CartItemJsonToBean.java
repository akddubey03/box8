package com;

import com.google.gson.Gson;
import com.model.Cart;

public class CartItemJsonToBean {

	public static Cart getCart(String json) {

		Gson gson = new Gson();
		return gson.fromJson(json, Cart.class);

	}

}
