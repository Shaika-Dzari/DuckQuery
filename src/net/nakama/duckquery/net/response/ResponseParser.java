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


import java.util.ArrayList;
import java.util.Iterator;

import net.nakama.duckquery.net.response.api.Icon;
import net.nakama.duckquery.net.response.api.RelatedTopic;
import net.nakama.duckquery.net.response.api.ResponseType;
import net.nakama.duckquery.net.response.api.Result;
import net.nakama.duckquery.net.response.api.Topic;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;

public class ResponseParser {
	
	public static ZeroClickResponse parse(String json) throws Exception {
		ZeroClickResponse zr = new ZeroClickResponse();
		RelatedTopic rt = new RelatedTopic();
		
		ObjectMapper mapper = new ObjectMapper();
		JsonNode arrayNode;
		JsonNode node;
		Iterator<JsonNode> it;
		
		JsonNode rootNode = mapper.readValue(json, JsonNode.class);
		
		zr.setAbstractHtml(rootNode.path("Abstract").getTextValue());
		zr.setAbstractText(rootNode.path("AbstractText").getTextValue());
		zr.setAbstractSource(rootNode.path("AbstractSource").getTextValue());
		zr.setAbstractURL(rootNode.path("AbstractURL").getTextValue());
		zr.setImage(rootNode.path("Image").getTextValue());
		zr.setHeading(rootNode.path("Heading").getTextValue());
		zr.setAnswer(rootNode.path("Answer").getTextValue());
		zr.setRedirect(rootNode.path("Redirect").getTextValue());
		zr.setAnswerType(rootNode.path("AnswerType").getTextValue());
		zr.setDefinition(rootNode.path("Definition").getTextValue());
		zr.setDefinitionSource(rootNode.path("DefinitionSource").getTextValue());
		zr.setDefinitionURL(rootNode.path("DefinitionURL").getTextValue());
		zr.setType(ResponseType.fromString(rootNode.path("Type").getTextValue()));
		
		
		// Related Topic
		arrayNode = rootNode.path("RelatedTopics");
		it = arrayNode.getElements();
				
		
		while (it.hasNext()) {
			node = it.next();
			
			JsonNode childNode = node.get("Topics");
			
			// If topics is null, it means we have a Result
			if (childNode == null) { 
				rt.getResults().add(parseResultNode(node));
			} else {
				rt.getTopics().add(parseTopicNode(node, childNode));
			}
		}
		
		zr.setRelatedTopics(rt);
		
		// Results
		zr.setResults(new ArrayList<Result>());
		arrayNode = rootNode.path("Results");
		it = arrayNode.getElements();
		
		while (it.hasNext()) {
			node = it.next();
			zr.getResults().add(parseResultNode(node));
		}
		
		return zr;
	}
	
	private static Result parseResultNode(JsonNode node) {
		Result result = new Result();
		
		Icon icon = new Icon();
		JsonNode childNode = node.get("Icon");
		
		result.setResultUrlText(node.get("Result").getTextValue());
		result.setUrl(node.get("FirstURL").getTextValue());
		result.setText(node.get("Text").getTextValue());
		
		icon.setUrl(childNode.get("URL").getTextValue());
		icon.setWidth(childNode.get("Height").getIntValue());
		icon.setHeight(childNode.get("Width").getIntValue());
		
		result.setIcon(icon);
		
		return result;
	}
	
	private static Topic parseTopicNode(JsonNode parentNode, JsonNode childNode) {
		Topic topic = new Topic();
		
		topic.setName(parentNode.get("Name").getTextValue());
		
		Iterator<JsonNode> it = childNode.getElements();
		JsonNode node;		
		
		while (it.hasNext()) {
			node = it.next();
			topic.getResults().add(parseResultNode(node));
		}
		
		
		return topic;
	}
}
