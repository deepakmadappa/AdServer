package com.cse535.AdvertizeServer;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import linearregression.Train;

public class Bidder {
	private static Bidder mInstance = null;
	HashMap<String, Keyword> mKeyWordsMap = new HashMap<String, Keyword>();
	Train mRegressionModel;
	private Bidder() {
		try {
			mRegressionModel = new Train();
			
			List<String> keywords1 = Files.readAllLines(Paths.get("./keywords-dataset-1.txt"), null);
			List<String> keywords2 = Files.readAllLines(Paths.get("./keywords-dataset-2.txt"), null);
			for (String string : keywords1) {
				Keyword key = new Keyword();
				key.mKeyword = string;
				Random rGen = new Random();
				int rand = rGen.nextInt(10);
				key.mBid = rand + 5;
				mKeyWordsMap.put(string, key);
			}
			
			for (String string : keywords2) {
				Keyword key = new Keyword();
				key.mKeyword = string;
				Random rGen = new Random();
				int rand = rGen.nextInt(10);
				key.mBid = rand + 5;
				mKeyWordsMap.put(string, key);
			}
		}
		catch (Exception ex) {
			
		}
	}
	
	public static Bidder Instance() {
		if(mInstance == null) {
			mInstance = new Bidder();
		}
		return mInstance;
	}
	
	public double GetBid(KeywordDetails kd, int mode) {
		switch (mode) {
		case 0:
			//returns random
			Random rGen = new Random();
			int rand = rGen.nextInt(10);
			return rand + 5.0;
		case 1:
			//returns last bid plus 1 cent
			return kd.mLastBidCost + 0.01;
		case 2:
			double lastCtr = kd.mLastBidClicks / kd.mLastBidImpressions * 100;
			double lastRelevanceScore = ((kd.mLastBidRank / 20) + 1 ) * lastCtr;
			double thisRelevanceScore = ((kd.mThisBidRank / 20) + 1 ) * lastCtr;
			
			return mRegressionModel.getData(lastRelevanceScore , kd.mLastBidCost, thisRelevanceScore);
			//returns ML regressed value;
		default:
			//no bid
			return 0;
		}
	}
}
