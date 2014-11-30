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
		String mainDir = "C:\\Classes\\CSE 535 - IR\\Project3\\Dataset\\bids";
		File ipDirectory = new File(mainDir);
		String[] catDirectories = ipDirectory.list();
		
		String[] files;
		File dir;
		
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
								key.mLastBidValue = rnd.nextInt(10) + 5;
								String[] tokens = line.split("\\t");
								String strClicks = tokens[12];
								float clicks = Float.parseFloat(strClicks);
								key.mClicks = (int) clicks;
								String strImp = tokens[15];
								float impressions = Float.parseFloat(strImp);
								key.mImpressions = (int) impressions;
								String keyWord = tokens[7];
								mMap.put(keyWord, key);
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
	}
}
