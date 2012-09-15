/*
 * HttpClient.java
 * 
 * This program is free software. It comes without any warranty, to
 * the extent permitted by applicable law. You can redistribute it
 * and/or modify it under the terms of the Do What The Fuck You Want
 * To Public License, Version 2, as published by Sam Hocevar. 
 * See http://sam.zoy.org/wtfpl/COPYING for more details. 
 * 
 * @author shaika-dzari
 * @since 2012-09-13
 */ 
package net.nakama.duckquery.net.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class HttpClient {
	
	public String get(String query) throws Exception {
		URL url = null;
	    BufferedReader reader = null;
	    StringBuilder sb = new StringBuilder();
	    HttpURLConnection hc = null;
	    String l;
	    
		try {
			url = new URL(query);
			hc = (HttpURLConnection) url.openConnection();
			hc.setRequestMethod("GET");
			hc.setReadTimeout(15*1000);
		    hc.connect();

		    reader = new BufferedReader(new InputStreamReader(hc.getInputStream()));
		
		    while ((l = reader.readLine()) != null) {
		        sb.append(l);
		    }
		    
		} finally {
			if (hc != null)
				hc.disconnect();
			if (reader != null)
				reader.close();
		}
		
		return sb.toString();
	}
	
	public String escape(String args) throws Exception {
		return URLEncoder.encode(args, "UTF-8");
	}
}
