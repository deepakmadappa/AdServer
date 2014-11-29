package org.autobots.adserver.searchengine;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.autobots.adserver.models.SearchResult;
import org.autobots.adserver.models.SearchType;

public class SearchEngine {

	private SolrServer server;

	public SearchEngine(String url) {
		server = new HttpSolrServer(url);
	}

	public List<SearchResult> query(String queryString, SearchType type) {
		List<SearchResult> list = new ArrayList<SearchResult>();
		if (queryString == null || queryString.isEmpty())
			return list;
		SolrQuery query = new SolrQuery();
		query.set("q", queryString);
		//TODO fix highlighting
		query.set("hl", "true");
		query.set("hl.fl", "body");
		query.set("hl.simple.pre", "<mark><b><i>");
		query.set("hl.simple.post", "</i></b></mark>");
		query.set("f.body.hl.fragsize", "200");
		System.out.println(query.toString());
		try {
			QueryResponse response = server.query(query);
			SolrDocumentList results = response.getResults();
			Map<String, Map<String, List<String>>> snippetMap = response
					.getHighlighting();
			Iterator<SolrDocument> iterator = results.iterator();
			while (iterator.hasNext()) {
				SolrDocument document = iterator.next();
				String id = document.getFieldValue("id").toString();
				String content = "";
				String title = document.getFieldValue("title").toString();
				if (type == SearchType.Search) {
					List<String> highlightContent = snippetMap.get(id).get(
							"body");
					if (highlightContent != null && !highlightContent.isEmpty())
						content = highlightContent.get(0);
				} else if (type == SearchType.Ad)
					content = document.getFieldValue("html").toString();
				// TODO change link
				list.add(new SearchResult(id, title, content, ""));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
