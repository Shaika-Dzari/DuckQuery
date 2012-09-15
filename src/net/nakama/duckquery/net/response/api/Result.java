/*
 * Result.java
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
package net.nakama.duckquery.net.response.api;

public class Result {
	
	/**
	 * @note api name = Result
	 */
	private String resultUrlText = null;
	
	/**
	 * @note api name = FirstURL
	 */
	private String url = null;
	private String text = null;
	private Icon icon = null;
	
	/**
	 * @return the resultUrlText
	 */
	public String getResultUrlText() {
		return resultUrlText;
	}
	/**
	 * @param resultUrlText the resultUrlText to set
	 */
	public void setResultUrlText(String resultUrlText) {
		this.resultUrlText = resultUrlText;
	}
	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}
	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}
	/**
	 * @return the icon
	 */
	public Icon getIcon() {
		return icon;
	}
	/**
	 * @param icon the icon to set
	 */
	public void setIcon(Icon icon) {
		this.icon = icon;
	}
	
	
}
