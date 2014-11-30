package org.autobots.adserver.utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.autobots.adserver.models.KeywordParams;


public class Parser {
	public Map<String, KeywordParams> mMap = new HashMap<String, KeywordParams>();
	public void parse() {
		String mainDir = "bids";
		File ipDirectory = new File(mainDir);
		String[] catDirectories = ipDirectory.list();

		String[] files;
		File dir;
		double max = 0.10624621494266268;

		try {
			for (String cat : catDirectories) {
				dir = new File(mainDir+ File.separator+ cat);
				files = dir.list();

				if (files == null)
					continue;

				for (String f : files) {
					try {
						String filename = mainDir+ File.separator+ cat+ File.separator + f;
						BufferedReader buffReader = new BufferedReader (new InputStreamReader(new FileInputStream(filename), "UTF-16"));
						String line = null;
						//ignore the first line
						line = buffReader.readLine();
						while((line = buffReader.readLine())!= null){
							try {
								KeywordParams key = new KeywordParams();
								Random rnd = new Random();
								key.mLastWinningBid = rnd.nextInt(10) + 5;
								String[] tokens = line.split("\\t");
								String strClicks = tokens[12];
								float clicks = Float.parseFloat(strClicks);
								key.mLastClicks =  clicks;
								String strImp = tokens[15];
								float impressions = Float.parseFloat(strImp);
								key.mLastImpressions =  impressions;
								key.mLastWinningBidRank = 1;
								String keyWord = tokens[7];
								if(clicks != 0 && impressions !=0 ) {
									if(mMap.containsKey(keyWord)) {
										KeywordParams current = mMap.get(keyWord);
										key.mLastClicks += current.mLastClicks;
										key.mLastImpressions += current.mLastImpressions;
									}
									mMap.put(keyWord, key);
								}
							} catch (Exception ex1) {

							}
						}
						buffReader.close();
					}
					catch(Exception ex) {
						System.out.println(ex.getMessage());
					}
					finally {

					}
				}
			}
		} catch (Exception e) {

		}
		try {
			//PrintWriter writer = new PrintWriter(new FileWriter("out.txt"));
			for (KeywordParams key : mMap.values()) {
				double ctr = (key.mLastClicks) /key.mLastImpressions ;
				//if( ctr > max) max = ctr;
				double bid = 10 * ctr/max;
				bid += 5;
				key.mLastWinningBid = bid;
			//	writer.println(bid + "," + (key.mLastClicks * 100/ key.mLastImpressions));
			}
			//writer.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
//		System.out.println(max);
	}
}
