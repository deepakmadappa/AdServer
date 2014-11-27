package com.cse535.client;

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import com.cse535.AdvertizeServer.*;


public class HelloWorldClient{
 
	public static void main(String[] args) throws Exception {
 
	URL url = new URL("http://localhost:9999/ws/hello?wsdl");
 
        //1st argument service URI, refer to wsdl document above
	//2nd argument is service name, refer to wsdl document above
        QName qname = new QName("http://AdvertizeServer.cse535.com/", "ServerImplService");
 
        Service service = Service.create(url, qname);
        
        Server hello = service.getPort(Server.class);
        KeywordDetails details = new KeywordDetails();
        details.mKeyWord = "secure online back up";
        System.out.println(hello.getBid(details));
    }
}