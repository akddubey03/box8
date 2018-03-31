package com;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import com.google.gson.Gson;
import com.model.CouponList;

public class CouponReader {

	public static CouponList getCoupons() {
		JSONParser jsonParser = new JSONParser();
		CouponList couponList = new CouponList();
		try (FileReader reader = new FileReader("coupon_codes.json")) {
			// Read JSON file
			Object obj = jsonParser.parse(reader);

			JSONObject couponsJson = (JSONObject) obj;
			String s1 = couponsJson.toJSONString();
			Gson gson = new Gson();
			couponList = gson.fromJson(s1, CouponList.class);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return couponList;
	}

}
