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

import net.nakama.duckquery.net.request.Request;

public class DuckQueryBuilder {

	private static final String DDG_API_URL = "https://api.duckduckgo.com/?";
	private static final String ARG_NO_HTML = "no_html=1";
	private static final String ARG_SAFEOFF = "kp=-1";
	private static final String ARG_PRETTY = "pretty=1";
	private static final String ARG_FORMAT_JSON = "format=json";
	private static final String ARG_FORMAT_XML = "format=xml";
	//private static final String ARG_NO_REDIRECT = "no_redirect=1";
	private static final String ARG_SKIP_DISAMBIG = "skip_disambig=1";
	
	
	private static final String AMP = "&";
	private static final String ARG_STD = "&no_html=1&no_redirect=1&format=json";
	
	public String buildAndCall(Request request, HttpClient client) throws Exception {
		return client.get(build(request, client));
	}
	
	public String build(Request request, HttpClient client) throws Exception {
		
		String query = DDG_API_URL + "q=" + this.escape(request.getQuery());
		
		if (request.isStandard()) {
			query += ARG_STD;
		} else {
			query +=(request.isNoHtml()) ? AMP + ARG_NO_HTML : "";
			//query += AMP + ((request.isNoRedirect()) ? ARG_NO_REDIRECT : "");
			query += (request.isFormatJson()) ? AMP + ARG_FORMAT_JSON : AMP + ARG_FORMAT_XML;
			query += (request.isPretty()) ? AMP + ARG_PRETTY : "";
			query += (request.isSkipDisambig()) ? AMP + ARG_SKIP_DISAMBIG : "";
			query += (request.isSafeOff()) ? AMP + ARG_SAFEOFF : "";
		}
		
		
		return query;
	}
	

	public String escape(String args) throws Exception {
		return URLEncoder.encode(args, "UTF-8");
	}
}
