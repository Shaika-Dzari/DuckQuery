/*
 * DuckQuery.java
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
package net.nakama.duckquery;

import net.nakama.duckquery.net.client.DuckHttpClient;
import net.nakama.duckquery.net.client.HttpClient;
import net.nakama.duckquery.net.response.ResponseParser;
import net.nakama.duckquery.net.response.ZeroClickResponse;

public class DuckQuery {
	
	private HttpClient httpClient = new DuckHttpClient();
	
	public String doJsonQuery(String query) throws Exception {
		return httpClient.get(query);
	}
	
	public ZeroClickResponse doQuery(String query) throws Exception {
		String json = doJsonQuery(query);
		return ResponseParser.parse(query, json);
	}
}
