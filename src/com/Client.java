package com;

public class Client {

	public static void main(String[] args) {
		CouponOnCart c1 = new CouponOnCart();
		System.out.println(c1.getCouponOnCart(c1.cart_items, "HELLOBOX8", 3));

	}

}
