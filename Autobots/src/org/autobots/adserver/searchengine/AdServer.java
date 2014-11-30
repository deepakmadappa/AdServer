package org.autobots.adserver.searchengine;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import org.autobots.adserver.models.SearchResult;

import com.cse535.AdvertizeServer.KeywordDetails;
import com.cse535.AdvertizeServer.Server;

public class AdServer {

	private Service service;

	public AdServer() {
		URL url;
		try {
			url = new URL("http://localhost:9999/ws/hello?wsdl");
			QName qname = new QName("http://AdvertizeServer.cse535.com/", "ServerImplService");
			service = Service.create(url, qname);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	public List<SearchResult> getBid(List<SearchResult> keywords) {
		//List<Bid> bids = new ArrayList<Bid>();
		Server server = service.getPort(Server.class);
		for (SearchResult word : keywords) {
			KeywordDetails details = new KeywordDetails(word.getKeyword());
			//Bid bid = new Bid(word.getId());
			try {
				word.setBid(server.getBid(details));
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			//bids.add(bid);
		}
		return keywords;
	}

}