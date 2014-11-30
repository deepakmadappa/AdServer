package com.cse535.AdvertizeServer;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Bidder {
	private static Bidder mInstance = null;
	HashMap<String, Keyword> mKeyWordsMap = new HashMap<String, Keyword>();
	private Bidder() {
		try {
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
	
	public int GetBid(KeywordDetails kd) {
		if(mKeyWordsMap.containsKey(kd.mKeyWord)) {
			return mKeyWordsMap.get(kd.mKeyWord).mBid;
		}
		return 0;
	}
	
}
