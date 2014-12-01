package org.autobots.adserver.searchengine;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
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
		if (type == SearchType.Search)
			query.set("q", queryString);
		if (type == SearchType.Ad) {
			String qstr = "title:" + queryString + "^3" + "keyword:"
					+ queryString + "^1 html:" + queryString
					+ "^0.2 title:*^0.001";
			query.set("q", qstr);
			query.set("fl", "id,keyword,score,html,title");
		}
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
			int rank = 0;
			while (iterator.hasNext()) {
				rank++;
				SolrDocument document = iterator.next();
				String id = document.getFieldValue("id").toString();
				String content = "";
				String keyword = "";
				double score = 0;
				List<String> categoryList = new ArrayList<String>();
				String title = document.getFieldValue("title").toString();
				if (type == SearchType.Search) {
					List<String> highlightContent = snippetMap.get(id).get(
							"body");
					if (highlightContent != null && !highlightContent.isEmpty())
						content = highlightContent.get(0);
					Collection<Object> categories = document
							.getFieldValues("category");
					for (Object object : categories)
						categoryList.add(object.toString());
				} else if (type == SearchType.Ad) {
					content = document.getFieldValue("html").toString();
					keyword = document.getFieldValue("keyword").toString();
					score = Double.parseDouble(document.getFieldValue("score")
							.toString());
				}
				SearchResult res = new SearchResult(id, title, content, "",
						keyword);
				res.addCategories(categoryList);
				res.setRank(rank);
				res.setScore(score);
				list.add(res);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
