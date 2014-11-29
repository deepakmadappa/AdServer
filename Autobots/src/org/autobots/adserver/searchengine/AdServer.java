package org.autobots.adserver.searchengine;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class AdServer {

	public void connect() {
		try {
			URL url = new URL("http://localhost:9999/ws/hello?wsdl");
			QName qname = new QName("http://AdvertizeServer.cse535.com/", "ServerImplService");
			Service service = Service.create(url, qname);
			
			/*Server hello = service.getPort(Server.class);
			KeywordDetails details = new KeywordDetails();
			details.mKeyWord = "secure online back up";
			System.out.println(hello.getBid(details));*/
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

}