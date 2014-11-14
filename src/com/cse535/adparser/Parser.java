package com.cse535.adparser;
import net.htmlparser.jericho.*;

import java.util.*;
import java.io.*;
import java.io.ObjectInputStream.GetField;
import java.net.*;

public class Parser {
	private static String xmlString = "<doc>"
			+ "<field name=\"id\">fname</field>"
			+ "<field name=\"keyword\">kword</field>"
			+ "<field name=\"title\">desc</field>"
			+ "<field name=\"text\">html</field>"
			+ "</doc>";

	
	public static String getHTMLString(String fileName) {
		try {
			String sourceUrlString="C:/Classes/CSE 535 - IR/Project3/Dataset/webpages-dataset-2/webpages-dataset-2/"+fileName;
			/*if (sourceUrlString.indexOf(':')==-1)*/ sourceUrlString="file:"+sourceUrlString;
			Source source=new Source(new URL(sourceUrlString));
			String renderedText=source.getRenderer().toString();
			//System.out.println("\nSimple rendering of the HTML document:\n");
			//System.out.println(renderedText);
			return renderedText;
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return null;
	}

	public static void main(String[] args) 
	{
		try {
			String filename = "C:/Classes/CSE 535 - IR/Project3/Dataset/webpages-dataset-2/webpages-dataset-2.txt";
			BufferedReader buffReader = new BufferedReader (new FileReader(filename));
			String line = null;
			while((line = buffReader.readLine())!= null){
				String[] tokens = line.split("\\t");
				String html = getHTMLString(tokens[0]);
				//String xml = new String(xmlString);
				//xml = xml.replaceAll("kword", tokens[1]);
				//xml = xml.replaceAll("html", html);
				//xml = xml.replaceAll("desc", tokens[5]);
				//xml = xml.replaceAll("fname", tokens[0]);
				PrintWriter writer = new PrintWriter(tokens[0] + ".xml", "UTF-8");
				writer.println( "<doc>");
				writer.println("<field name=\"id\">"+ tokens[0]+"</field>");
				writer.println("<field name=\"keyword\">"+ tokens[1]+"</field>");
				writer.println("<field name=\"title\">"+ tokens[5]+"</field>");
				writer.println("<field name=\"html\">"+ html +"</field>");
				writer.println("</doc>");
				writer.close();
			}
			buffReader.close();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		finally  {
		
		}
		 
	}
}
