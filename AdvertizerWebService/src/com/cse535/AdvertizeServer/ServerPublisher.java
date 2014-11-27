package com.cse535.AdvertizeServer;

import javax.xml.ws.Endpoint;
 
//Endpoint publisher
public class ServerPublisher{
 
	public static void main(String[] args) {
	   Endpoint.publish("http://localhost:9999/ws/hello", new ServerImpl());
    }
 
}