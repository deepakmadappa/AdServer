package org.autobots.adserver.models;

public class SearchResult {

	private int id;
	private String title;
	private String snippet;
	private String link;

	public SearchResult() {
	}

	public SearchResult(int id, String title, String snippet, String link) {
		this.id = id;
		this.title = title;
		this.snippet = snippet;
		this.link = link;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
