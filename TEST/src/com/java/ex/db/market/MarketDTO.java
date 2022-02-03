package com.java.ex.db.market;

public class MarketDTO {
	private String market_name;
	private String location;
	private String staff_cnt;
	private String manager_name;

	
	public MarketDTO (String manager, String location, String staff_cnt) {
		this.market_name = market_name;
		this.location = location;
		this.staff_cnt = staff_cnt;
		this.manager_name = manager_name;

	}

	public String getManager_name() {
		return manager_name;
	}

	public void setManager_name(String manager_name) {
		this.manager_name = manager_name;
	}

	public String getMarket_name() {
		return market_name;
	}
	
	public void setMarket_name(String market_name) {
		this.market_name = market_name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getStaff_cnt() {
		return staff_cnt;
	}

	public void setStaff_cnt(String staff_cnt) {
		this.staff_cnt = staff_cnt;
	}

	
	
	
}
