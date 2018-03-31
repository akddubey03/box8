package com.model;

import java.util.List;

public class Coupon {
	
	private int id;
	private String code;
	private String type;
	private int value;
	private int cashback_value;
	private String start_date;
	private String end_date;
	private boolean active;
	private List<Integer> applicable_outlet_ids;
	private int minimum_delivery_amount_after_discount;
	private int maximum_discount;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public int getCashback_value() {
		return cashback_value;
	}
	public void setCashback_value(int cashback_value) {
		this.cashback_value = cashback_value;
	}
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public List<Integer> getApplicable_outlet_ids() {
		return applicable_outlet_ids;
	}
	public void setApplicable_outlet_ids(List<Integer> applicable_outlet_ids) {
		this.applicable_outlet_ids = applicable_outlet_ids;
	}
	public int getMinimum_delivery_amount_after_discount() {
		return minimum_delivery_amount_after_discount;
	}
	public void setMinimum_delivery_amount_after_discount(int minimum_delivery_amount_after_discount) {
		this.minimum_delivery_amount_after_discount = minimum_delivery_amount_after_discount;
	}
	public int getMaximum_discount() {
		return maximum_discount;
	}
	public void setMaximum_discount(int maximum_discount) {
		this.maximum_discount = maximum_discount;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coupon other = (Coupon) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		return true;
	}
	
	

}
