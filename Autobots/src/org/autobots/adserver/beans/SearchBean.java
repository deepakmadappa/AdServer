package org.autobots.adserver.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.autobots.adserver.models.SearchResult;
import org.autobots.adserver.searchengine.SearchEngine;

@ManagedBean
@SessionScoped
public class SearchBean {

	private String query;

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public void search() {
		System.out.println(query);
	}

	public List<SearchResult> getResult() {
		SearchEngine engine = new SearchEngine("http://localhost:8983/solr");
		return engine.query(query);
	}

}
