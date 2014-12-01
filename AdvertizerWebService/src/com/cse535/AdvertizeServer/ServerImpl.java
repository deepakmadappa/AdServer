package com.cse535.AdvertizeServer;

import javax.jws.WebService;

//Service Implementation
@WebService(endpointInterface = "com.cse535.AdvertizeServer.Server")
public class ServerImpl implements Server{
	int mMode;
	
	public ServerImpl(int mode) {
		mMode = mode;
	}
	
	@Override
	public double getBid(KeywordDetails info) {
		double bid = Bidder.Instance().GetBid(info, mMode);
		return bid;
	}
}