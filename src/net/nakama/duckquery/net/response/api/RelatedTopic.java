/*
 * RelatedTopic.java
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

public class RelatedTopic {

	private Result[] results = null;
	private Topic[] topics = null;
	
	/**
	 * @return the results
	 */
	public Result[] getResults() {
		return results;
	}
	/**
	 * @param results the results to set
	 */
	public void setResults(Result[] results) {
		this.results = results;
	}
	/**
	 * @return the topics
	 */
	public Topic[] getTopics() {
		return topics;
	}
	/**
	 * @param topics the topics to set
	 */
	public void setTopics(Topic[] topics) {
		this.topics = topics;
	}
	
	
}
