/*
 * CallOption.java
 * 
 * This program is free software. It comes without any warranty, to
 * the extent permitted by applicable law. You can redistribute it
 * and/or modify it under the terms of the Do What The Fuck You Want
 * To Public License, Version 2, as published by Sam Hocevar. 
 * See http://sam.zoy.org/wtfpl/COPYING for more details. 
 * 
 * @author shaika-dzari
 * @since 2012-10-15
 */ 
package net.nakama.duckquery.net.client;

import java.util.EnumSet;
import java.util.Set;

public class CallOption {
	
	private Set<DuckDuckGoOption> options;
	
	public enum DuckDuckGoOption {
		
		NO_HTML("no_html=1"),
		WITH_HTML("no_html=0"),
		SKIP_DISAMBIG("skip_disambig=1"), 
		SAFEOFF("kp=-1"), 
		SAFEON("kp=1"), 
		PRETTY("pretty=1"), 
		FORMAT_JSON("format=json"), 
		FORMAT_XML("format=xml"),
		NO_REDIRECT("no_redirect=1");
		 
		private String urlParam;;
		
		DuckDuckGoOption(String urlParam) {
			this.urlParam = urlParam;
		}
		
		public String getUrlParam() {
			return this.urlParam;
		}
	}
	
	public CallOption() {
		options = EnumSet.of(DuckDuckGoOption.FORMAT_JSON, DuckDuckGoOption.NO_REDIRECT, DuckDuckGoOption.NO_HTML);
	}
	
	public void addOption(DuckDuckGoOption opt) {
		if (opt == DuckDuckGoOption.FORMAT_XML) 
			options.remove(DuckDuckGoOption.FORMAT_JSON);
		else if (opt == DuckDuckGoOption.WITH_HTML) 
			options.remove(DuckDuckGoOption.NO_HTML);
		
		options.add(opt);
	}
	
	public String asString() {
		String u = "";
		
		for (DuckDuckGoOption d : options) {
			u += "&" + d.getUrlParam();
		}
		
		return u;
	}
	
}
