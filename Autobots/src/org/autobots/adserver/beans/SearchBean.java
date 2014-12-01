package org.autobots.adserver.beans;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.autobots.adserver.models.KeywordParams;
import org.autobots.adserver.models.SearchResult;
import org.autobots.adserver.models.SearchType;
import org.autobots.adserver.searchengine.AdServer;
import org.autobots.adserver.searchengine.SearchEngine;
import org.autobots.adserver.utilities.Parser;

import com.cse535.AdvertizeServer.KeywordDetails;

@ManagedBean
@SessionScoped
// @ApplicationScoped
public class SearchBean {

	private Parser keywordMap;
	private String query;
	private List<String> categories;
	private String selectedSearch;
	private SearchResult selectedResult;
	private String selectedAdName;
	private SearchResult selectedAd;
	private List<SearchResult> savedAds;

	public List<SearchResult> getResult() {
		SearchEngine engine = new SearchEngine(
				"http://localhost:8983/solr/newscore");
		List<SearchResult> res = engine.query(query, SearchType.Search);
		categories = extractCategories(res);
		return res;
	}

	public List<SearchResult> getAds() {
		SearchEngine engine = new SearchEngine(
				"http://localhost:8983/solr/adcore");
		AdServer adServer = new AdServer();
		List<SearchResult> results = engine.query(query, SearchType.Ad);
		List<SearchResult> bidList = adServer.getBid(results, keywordMap.mMap);
		double max = 0;
		for (SearchResult searchResult : bidList) {
			if (searchResult.getScore() > max)
				max = searchResult.getScore();
		}
		for (SearchResult searchResult : bidList) {
			double s = searchResult.getScore() / max * searchResult.getBid();
			searchResult.setCalculatedScore(s);
		}
		int count = 0;
		Collections.sort(bidList);
		List<SearchResult> finalList = new ArrayList<SearchResult>();
		SearchResult winner = null;
		for (SearchResult searchResult : bidList) {
			count++;
			if(count == 4)
				break;
			finalList.add(searchResult);
			KeywordParams details = keywordMap.mMap.get(searchResult.getKeyword());
			details.mLastImpressions++;
			if(winner == null)
				winner = searchResult;
			details.mLastWinningBid = winner.getBid();
			details.mLastWinningBidRank = winner.getRank();
		}
		savedAds = bidList;
		// List<Bid> bids = adServer.getBid(results);
		// TODO check display limit of ads
		return finalList;
	}

	private List<String> extractCategories(Collection<SearchResult> searches) {
		List<String> res = new ArrayList<String>();
		for (SearchResult search : searches) {
			for (String category : search.getCategories()) {
				if (!res.contains(category) && !category.isEmpty())
					res.add(category);
			}
		}
		return res;
	}

	public List<String> getCategories() {
		if (categories == null || categories.isEmpty())
			getResult();
		return categories;
	}

	public void setQuery(String query) {
		if (keywordMap == null)
			keywordMap = new Parser();
		if (keywordMap.mMap.isEmpty())
			keywordMap.parse();
		this.query = query;
	}

	public String goToAdPage(String adTitle) {
		for (SearchResult ad : savedAds) {
			if (ad.getTitle().equals(adTitle)) {
				selectedAd = ad;
				break;
			}
		}
		return "result";
	}

	public String getQuery() {
		return query;
	}

	public void setCategories(List<String> categories) {
		this.categories = categories;
	}

	public String getSelectedSearch() {
		return selectedSearch;
	}

	public void setSelectedSearch(String selectedSearch) {
		this.selectedSearch = selectedSearch;
	}

	public SearchResult getSelectedResult() {
		return selectedResult;
	}

	public void setSelectedResult(SearchResult selectedResult) {
		this.selectedResult = selectedResult;
	}

	public String getSelectedAdName() {
		return selectedAdName;
	}

	public void setSelectedAdName(String selectedAdName) {
		this.selectedAdName = selectedAdName;
	}

	public SearchResult getSelectedAd() {
		return selectedAd;
	}

	public void setSelectedAd(SearchResult selectedAd) {
		this.selectedAd = selectedAd;
	}

}
