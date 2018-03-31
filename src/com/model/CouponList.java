package com.model;

import java.util.ArrayList;
import java.util.List;

public class CouponList {
	
	private List<Coupon> coupon_codes=new ArrayList<>();

	public List<Coupon> getCoupons() {
		return coupon_codes;
	}

	public void setCoupons(List<Coupon> coupon_codes) {
		this.coupon_codes = coupon_codes;
	}
	
	

}
