/*
 * ResponseParser.java
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
package net.nakama.duckquery.net.response;


import net.nakama.duckquery.net.response.api.DDGApiField;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;



public class ResponseParser {

	public static ZeroClickResponse parse(String json) {
		ZeroClickResponse zr = new ZeroClickResponse();
		
		JSONObject j = (JSONObject) JSONSerializer.toJSON(json); 
		
		zr.setAbstractHtml(j.getString(DDGApiField.Abstract.toString()));
		
		return zr;
	}
}
