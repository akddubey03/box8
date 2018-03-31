package com;

import com.model.Cart;
import com.model.Coupon;
import com.model.Item;
import static com.Constant.*;

public class Discount {

	public int getDiscount(Coupon coupon, int totalBill, Cart cart) {

		String couponCode = coupon.getCode();

		outer: switch (couponCode) {
		case BOX8LOVE:

			totalBill = (int) ((totalBill) * (Double.valueOf(coupon.getValue()) / 100));
			break;
		case HELLOBOX8:
			totalBill = coupon.getValue();
			break;
		case GETCASHBACK:
			totalBill = coupon.getValue();
			break;
		case BOGO:
			int lowestPrice = Integer.MAX_VALUE;
			int unit_cost = 0;
			int countLowest = 0;
			int countOthers = 0;
			for (Item item : cart.getItems()) {
				if (item.getQuantity() % 2 != 0) {
					totalBill = 0;
					break outer;
				}
				unit_cost = item.getUnit_cost();
				if (unit_cost <= lowestPrice) {
					lowestPrice = unit_cost;

				}
			}
			for (Item item : cart.getItems()) {
				if (item.getUnit_cost() == lowestPrice)
					countLowest++;
				else
					countOthers++;
			}
			if (countLowest - countOthers == 0) {
				lowestPrice = lowestPrice * countLowest;
			}
			totalBill = lowestPrice;
			break;
		}
		return totalBill;
	}

}
