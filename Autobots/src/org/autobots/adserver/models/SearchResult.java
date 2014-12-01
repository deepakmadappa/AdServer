package org.autobots.adserver.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SearchResult implements Comparable<SearchResult> {

	private int rank;
	private String id;
	private String title;
	private String snippet;
	private String content;
	private String link;
	private String keyword;
	private double bid;
	private List<String> categories;

	public SearchResult() {
	}

	public SearchResult(String id, String title, String snippet, String link,
			String keyword) {
		this.id = id;
		this.title = title;
		this.snippet = snippet;
		this.link = link;
		this.keyword = keyword;
		categories = new ArrayList<String>();
	}

	@Override
	public int compareTo(SearchResult o) {
		if (this.bid > o.getBid())
			return 1;
		else if (this.bid == o.getBid())
			return 0;
		else
			return -1;
	}

	public String getCategoriesString() {
		String str = "";
		for (String category : categories) {
			str += category + ",";
		}
		if (str.length() > 0)
			str = str.substring(0, str.length() - 1);
		return str;
	}

	public void addCategories(Collection<String> categories) {
		this.categories.addAll(categories);
	}

	public void addCategory(String category) {
		categories.add(category);
	}

	public List<String> getCategories() {
		return categories;
	}

	public double getBid() {
		return bid;
	}

	public void setBid(double bid) {
		this.bid = bid;
	}

	public void setKeyword(String key) {
		keyword = key;
	}

	public String getKeyword() {
		return keyword;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSnippet() {
		return snippet;
	}

	public void setSnippet(String snippet) {
		this.snippet = snippet;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

}
