package org.autobots.adserver.searchengine;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class AdServer {

	public void connect(){
		try {
			URL url = new URL("");
			QName qname = new QName("", "");
			Service service = Service.create(url, qname);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	
}