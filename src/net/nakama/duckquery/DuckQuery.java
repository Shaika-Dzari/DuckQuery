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

import net.nakama.duckquery.net.client.CallOption;
import net.nakama.duckquery.net.client.DuckQueryBuilder;
import net.nakama.duckquery.net.client.HttpClient;
import net.nakama.duckquery.net.request.Request;
import net.nakama.duckquery.net.response.ResponseParser;
import net.nakama.duckquery.net.response.ZeroClickResponse;

public class DuckQuery {
	
	private DuckQueryBuilder queryBuilder;
	private HttpClient httpClient;
	
	
	public DuckQuery() {
		queryBuilder = new DuckQueryBuilder();
		httpClient = new HttpClient();
	}
	
	public String doSimpleQuery(String query) throws Exception {
		return doSimpleQuery(new Request(query, new CallOption()));
	}
	
	public String doSimpleQuery(Request request) throws Exception {
		return queryBuilder.buildAndCall(request.query, request.options, httpClient);
	}
	
	public ZeroClickResponse doQuery(String query) throws Exception {
		return doQuery(new Request(query, new CallOption()));
	}
	
	public ZeroClickResponse doQuery(Request request) throws Exception {
		String json = doSimpleQuery(request);
		return ResponseParser.parse(request.query, json);
	}
}
