package org.autobots.adserver.beans;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.autobots.adserver.models.SearchResult;
import org.autobots.adserver.models.SearchType;
import org.autobots.adserver.searchengine.AdServer;
import org.autobots.adserver.searchengine.SearchEngine;

@ManagedBean
@SessionScoped
public class SearchBean {

	private String query;
	private List<String> categories;

	public List<SearchResult> getResult() {
		SearchEngine engine = new SearchEngine("http://localhost:8983/solr/newscore");
		List<SearchResult> res = engine.query(query, SearchType.Search);
		categories = extractCategories(res);
		return res;
	}

	public List<SearchResult> getAds() {
		SearchEngine engine = new SearchEngine("http://localhost:8983/solr/adcore");
		AdServer adServer = new AdServer();
		List<SearchResult> results = engine.query(query, SearchType.Ad);
		List<SearchResult> bidList = adServer.getBid(results);
		Collections.sort(bidList);
		// List<Bid> bids = adServer.getBid(results);
		// TODO check display limit of ads
		return bidList;
	}

	private List<String> extractCategories(Collection<SearchResult> searches) {
		List<String> res = new ArrayList<String>();
		for (SearchResult search : searches) {
			for (String category : search.getCategories()) {
				if (!res.contains(category))
					res.add(category);
			}
		}
		return res;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public List<String> getCategories() {
		if (categories == null || categories.isEmpty())
			getResult();
		return categories;
	}

	public void setCategories(List<String> categories) {
		this.categories = categories;
	}

}
