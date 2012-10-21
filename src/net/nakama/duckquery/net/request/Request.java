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

public class Request {

	private String query;
	private boolean noHtml = true;
	//private boolean noRedirect = true;
	private boolean skipDisambig = false;
	private boolean pretty = false;
	private boolean formatJson = true;
	
	private boolean safeOff = false;
	
	
	private boolean standard;
	
	public Request(String query) {
		this.query = query;
	}

	public static Request stdRequest(String query) {
		Request r = new Request(query);
		r.standard = true;
		return r;
	}

	/**
	 * @return the query
	 */
	public String getQuery() {
		return query;
	}


	/**
	 * @param query the query to set
	 */
	public void setQuery(String query) {
		this.query = query;
	}


	/**
	 * @return the noHtml
	 */
	public boolean isNoHtml() {
		return noHtml;
	}


	/**
	 * @param noHtml the noHtml to set
	 */
	public void setNoHtml(boolean noHtml) {
		this.noHtml = noHtml;
		this.standard = false;
	}


//	/**
//	 * @return the noRedirect
//	 */
//	public boolean isNoRedirect() {
//		return noRedirect;
//	}
//
//
//	/**
//	 * @param noRedirect the noRedirect to set
//	 */
//	public void setNoRedirect(boolean noRedirect) {
//		this.noRedirect = noRedirect;
//	}


	/**
	 * @return the skipDisambig
	 */
	public boolean isSkipDisambig() {
		return skipDisambig;
	}


	/**
	 * @param skipDisambig the skipDisambig to set
	 */
	public void setSkipDisambig(boolean skipDisambig) {
		this.skipDisambig = skipDisambig;
		this.standard = false;
	}


	/**
	 * @return the pretty
	 */
	public boolean isPretty() {
		return pretty;
	}


	/**
	 * @param pretty the pretty to set
	 */
	public void setPretty(boolean pretty) {
		this.pretty = pretty;
		this.standard = false;
	}


	/**
	 * @return the formatJson
	 */
	public boolean isFormatJson() {
		return formatJson;
	}


	/**
	 * @param formatJson the formatJson to set
	 */
	public void setFormatJson(boolean formatJson) {
		this.formatJson = formatJson;
		this.standard = false;
	}


	/**
	 * @return the standard
	 */
	public boolean isStandard() {
		return standard;
	}

	/**
	 * @return the safeOff
	 */
	public boolean isSafeOff() {
		return safeOff;
	}

	/**
	 * @param safeOff the safeOff to set
	 */
	public void setSafeOff(boolean safeOff) {
		this.safeOff = safeOff;
		this.standard = false;
	}
	
}
