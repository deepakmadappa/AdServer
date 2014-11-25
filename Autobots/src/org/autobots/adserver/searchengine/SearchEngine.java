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
		SolrQuery query = new SolrQuery();
		query.set("q", queryString);
		try {
			QueryResponse response = server.query(query);
			SolrDocumentList results = response.getResults();
			//System.out.println("no. of documents: " + results.size());
			Iterator<SolrDocument> iterator = results.iterator();
			while (iterator.hasNext()) {
				SolrDocument document = iterator.next();
				list.add(new SearchResult(document.getFieldValue("title").toString(), 
						document.getFieldValue("content").toString(), 
						document.getFieldValue("resourcename").toString()));
			}
		} catch (SolrServerException e) {
			System.out.println(e.getStackTrace());
		}
		return list;
	}

}
