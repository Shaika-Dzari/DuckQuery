/*
 * DuckHttpClient.java
 * 
 * This program is free software. It comes without any warranty, to
 * the extent permitted by applicable law. You can redistribute it
 * and/or modify it under the terms of the Do What The Fuck You Want
 * To Public License, Version 2, as published by Sam Hocevar. 
 * See http://sam.zoy.org/wtfpl/COPYING for more details. 
 * 
 * @author shaika-dzari
 * @since 2012-09-14
 */ 
package net.nakama.duckquery.net.client;

public class DuckHttpClient extends HttpClient {

	private static final String DDG_API_URL = "https://api.duckduckgo.com/?";
	private static final String DDG_API_STD_ARGS = "&format=json&no_redirect&no_html=1";
	
	@Override
	public String get(String query) throws Exception {
		String u = "q=" + this.escape(query);
		return super.get(DDG_API_URL + u + DDG_API_STD_ARGS);
	}
	
	
}
