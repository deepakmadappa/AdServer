package org.autobots.adserver.models;

public class Bid {

	private String searchId;
	private int bid;

	public Bid() {
	}

	public Bid(String searchId) {
		this.searchId = searchId;
	}

	public String getSearchId() {
		return searchId;
	}

	public void setSearchId(String searchId) {
		this.searchId = searchId;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}
}
