/*
 * ResponseType.java
 * 
 * This program is free software. It comes without any warranty, to
 * the extent permitted by applicable law. You can redistribute it
 * and/or modify it under the terms of the Do What The Fuck You Want
 * To Public License, Version 2, as published by Sam Hocevar. 
 * See http://sam.zoy.org/wtfpl/COPYING for more details. 
 * 
 * @author shaika-dzari
 * @since 2012-09-17
 */ 
package net.nakama.duckquery.net.response.api;

public enum ResponseType {
	A("Article"), D("Disambiguation"), C("Category"), N("Name"), E("Exclusive");
	
	private String desc;
	
	ResponseType(String desc) {
		this.desc = desc;
	}
	
	public String getDescription() {
		return this.desc;
	}
	
	public static ResponseType fromString(String v) {
		if (v.equals(""))
			return null;
		
		return ResponseType.valueOf(v);
	}
}
