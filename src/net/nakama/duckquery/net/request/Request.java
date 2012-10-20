/*
 * Request.java
 * 
 * This program is free software. It comes without any warranty, to
 * the extent permitted by applicable law. You can redistribute it
 * and/or modify it under the terms of the Do What The Fuck You Want
 * To Public License, Version 2, as published by Sam Hocevar. 
 * See http://sam.zoy.org/wtfpl/COPYING for more details. 
 * 
 * @author shaika-dzari
 * @since 2012-10-20
 */ 
package net.nakama.duckquery.net.request;

import net.nakama.duckquery.net.client.CallOption;

public class Request {

	public String query;
	public CallOption options;
	
	public Request(String query) {
		this(query, null);
	}
	public Request(String query, CallOption options) {
		this.query = query;
		this.options = options;
	}
}
