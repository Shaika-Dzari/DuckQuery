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

import java.net.URLEncoder;

public class DuckQueryBuilder {

	private static final String DDG_API_URL = "https://api.duckduckgo.com/?";
	
	public String buildAndCall(String query, CallOption options, HttpClient client) throws Exception {
		return client.get(build(query, options, client));
	}
	
	public String build(String query, CallOption options, HttpClient client) throws Exception {
		return DDG_API_URL + "q=" + this.escape(query) + options.asString();
	}
	

	public String escape(String args) throws Exception {
		return URLEncoder.encode(args, "UTF-8");
	}
}
