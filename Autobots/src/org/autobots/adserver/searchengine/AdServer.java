package org.autobots.adserver.searchengine;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import org.autobots.adserver.models.KeywordParams;
import org.autobots.adserver.models.SearchResult;

import com.cse535.AdvertizeServer.KeywordDetails;
import com.cse535.AdvertizeServer.Server;

public class AdServer {

	private List<Service> services;

	public AdServer() {
		services = new ArrayList<Service>();
		List<String> urls = new ArrayList<String>();
		urls.add("http://localhost:9999/ws/hello?wsdl");
		urls.add("http://localhost:9998/ws/hello?wsdl");
		urls.add("http://localhost:9997/ws/hello?wsdl");
		URL url;
		for (String urlStr : urls) {
			try {
				url = new URL(urlStr);
				QName qname = new QName("http://AdvertizeServer.cse535.com/",
						"ServerImplService");
				services.add(Service.create(url, qname));
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}
	}

	public List<SearchResult> getBid(List<SearchResult> keywords,
			Map<String, KeywordParams> map) {
		for (SearchResult word : keywords) {
			KeywordParams params;
			if (map.containsKey(word.getKeyword()))
				params = map.get(word.getKeyword());
			else {
				params = new KeywordParams();
				params.mLastClicks = 1;
				params.mLastImpressions = 100;
				params.mLastWinningBid = 15;
				params.mLastWinningBidRank = 1;
				map.put(word.getKeyword(), params);
			}
			KeywordDetails details = new KeywordDetails();
			details.setMKeyWord(word.getKeyword());
			details.setMThisBidRank(word.getRank());
			details.setMLastBidClicks(params.mLastClicks);
			details.setMLastBidCost(params.mLastWinningBid);
			details.setMLastBidImpressions(params.mLastImpressions);
			details.setMLastBidRank(params.mLastWinningBidRank);
			int serverId = Math.abs(Integer.parseInt(word.getId())) % 3;
			try {
				Server server = services.get(serverId).getPort(Server.class);
				word.setBid(server.getBid(details));
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			// bids.add(bid);
		}
		return keywords;
	}

}