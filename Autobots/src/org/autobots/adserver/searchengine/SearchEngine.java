package org.autobots.adserver.searchengine;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.autobots.adserver.models.SearchResult;

public class SearchEngine {

	private SolrServer server;

	public SearchEngine(String url) {
		server = new HttpSolrServer(url);
	}

	public List<SearchResult> query(String queryString) {
		List<SearchResult> list = new ArrayList<SearchResult>();
		if (queryString.isEmpty())
			return list;
		SolrQuery query = new SolrQuery();
		query.set("q", queryString);
		try {
			QueryResponse response = server.query(query);
			SolrDocumentList results = response.getResults();
			Iterator<SolrDocument> iterator = results.iterator();
			while (iterator.hasNext()) {
				SolrDocument document = iterator.next();
				int id = Integer.parseInt(document.getFieldValue("id").toString());
				String content = document.getFieldNames().contains("body") ? 
						document.getFieldValue("body").toString() : 
						document.getFieldValue("html").toString();
				String title = document.getFieldValue("title").toString();
				//TODO change link
				list.add(new SearchResult(id, title, content, ""));
			}
		} catch (SolrServerException e) {
			System.out.println(e.getStackTrace());
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
		return list;
	}

}
