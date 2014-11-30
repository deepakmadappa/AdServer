package com.cse535.AdvertizeServer;

import javax.xml.ws.Endpoint;

//Endpoint publisher
public class ServerPublisher{

	public static void main(String[] args) {
		int mode = Integer.parseInt(args[0]);
		int port = Integer.parseInt(args[1]);
		Endpoint.publish("http://localhost:"+ port +"/ws/hello", new ServerImpl(mode));
	}

}