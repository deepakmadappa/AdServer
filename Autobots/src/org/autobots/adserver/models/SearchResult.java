package org.autobots.adserver.models;

public class SearchResult {

	private String documentName;
	private String snippet;
	private String link;
	
	public SearchResult(){}
	
	public SearchResult(String docName, String snippet, String link){
		documentName = docName;
		this.snippet = snippet;
		this.link = link;
	}

	public String getDocumentName() {
		return documentName;
	}

	public void setDocumentName(String documentName) {
		this.documentName = documentName;
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

}
