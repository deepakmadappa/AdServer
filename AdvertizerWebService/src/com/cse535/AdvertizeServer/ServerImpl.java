package com.cse535.AdvertizeServer;

import javax.jws.WebService;

//Service Implementation
@WebService(endpointInterface = "com.cse535.AdvertizeServer.Server")
public class ServerImpl implements Server{
	
	@Override
	public int getBid(KeywordDetails info) {
		return Bidder.Instance().GetBid(info);
	}
}