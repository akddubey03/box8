package com;

import java.time.LocalDate;
import static com.Constant.*;
import java.time.format.DateTimeFormatter;

import org.json.simple.JSONObject;

import com.model.Cart;
import com.model.Coupon;
import com.model.CouponList;
import com.model.Item;

public class CouponOnCart {

	String cart_items = "{" + "\"cart_items\": [" + "{" + "\"product_id\": 1," + "\"quantity\": 2,"
			+ "\"unit_cost\": 100" + "}," + "{" + " \"product_id\": 1," + " \"quantity\": 2," + " \"unit_cost\": 200"
			+ " }" + ",{" + " \"product_id\": 1," + " \"quantity\": 2," + " \"unit_cost\": 100" + " }" + ",{"
			+ " \"product_id\": 1," + " \"quantity\": 2," + " \"unit_cost\": 200" + " }" +

			"]}";

	public String getCouponOnCart(String cart_items, String coupon_code, int outlet_id) {

		Cart cart = CartItemJsonToBean.getCart(cart_items);
		CouponList couponList = CouponReader.getCoupons();
		Coupon c1 = new Coupon();
		c1.setCode(coupon_code);
		String message = null;
		boolean isValid = false;
		int discount = 0;
		int cashback = 0;
		int index = couponList.getCoupons().indexOf(c1);
		if (index != -1) {
			c1 = couponList.getCoupons().get(index);
			isValid = isCouponValid(c1, cart, outlet_id);
			int totalBill = totalBill(cart, c1);
			discount = isValid ? new Discount().getDiscount(c1, totalBill, cart) : discount;
			if (discount > c1.getMaximum_discount())
				discount = c1.getMaximum_discount();
			message = isValid ? getMessage(discount, totalBill, c1) : MESSAGE_FAILED;
			discount = message.equals(MESSAGE_FAILED) ? 0 : discount;
			cashback = isValid ? c1.getCashback_value() : cashback;

		}
		JSONObject finalDiscountJsonObject = new JSONObject();
		finalDiscountJsonObject.put(VALID, isValid);
		finalDiscountJsonObject.put(MESSAGE, message);
		finalDiscountJsonObject.put(DISCOUNT, discount);
		finalDiscountJsonObject.put(CASHBACK, cashback);

		return finalDiscountJsonObject.toJSONString();
	}

	private boolean isCouponValid(Coupon coupon, Cart cart, int outlet_id) {
		boolean isValid = true;
		DateTimeFormatter format = DateTimeFormatter.ofPattern(DATE_PATTERN);
		LocalDate startDate = LocalDate.parse(coupon.getStart_date(), format);
		LocalDate endDate = LocalDate.parse(coupon.getEnd_date(), format);
		LocalDate currentDate = LocalDate.now();
		if (!coupon.isActive())
			return false;
		if (currentDate.isBefore(startDate) || currentDate.isAfter(endDate))
			return false;
		if (coupon.getApplicable_outlet_ids().size() == 0)
			return true;
		if (!coupon.getApplicable_outlet_ids().contains(outlet_id))
			return false;

		return isValid;

	}

	private int totalBill(Cart cart, Coupon c1) {
		int totalBill = 0;
		for (Item item : cart.getItems()) {
			if (c1.getCode().equals(BOGO))
				totalBill += item.getUnit_cost();
			else
				totalBill += item.getQuantity() * item.getUnit_cost();
		}
		return totalBill;
	}

	private String getMessage(int discount, int totalBill, Coupon coupon) {
		if (coupon.getCode().equals(BOGO) && discount == 0) {

			return MESSAGE_FAILED;
		}

		if (totalBill - discount < coupon.getMinimum_delivery_amount_after_discount())
			return MESSAGE_FAILED;

		return MESSAGE_SUCCESS;
	}

}
