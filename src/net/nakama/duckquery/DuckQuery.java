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

public class DuckQuery {
	
	private HttpClient httpClient = new DuckHttpClient();
	
	public String doQuery(String query) {
		try {
			return httpClient.get(query);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
		DuckQuery dg = new DuckQuery();
		
		try {
			String result = dg.doQuery("duckduckgo");
			System.out.println(result);
			
			result = dg.doQuery("duckduckgo !w");
			System.out.println(result);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
