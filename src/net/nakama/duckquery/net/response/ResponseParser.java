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

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import net.nakama.duckquery.net.response.api.DDGApiField;
import net.nakama.duckquery.net.response.api.Icon;
import net.nakama.duckquery.net.response.api.RelatedTopic;
import net.nakama.duckquery.net.response.api.Result;
import net.nakama.duckquery.net.response.api.Topic;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;





public class ResponseParser {

	public static ZeroClickResponse parse(String json) throws Exception {
		
		//ObjectMapper mapper = new ObjectMapper();
		//Map<String, Object> m = 
		
		JsonFactory f = new JsonFactory();
		JsonParser p = f.createJsonParser(json);
		ZeroClickResponse zr = new ZeroClickResponse();
		String fName;
		List<Result> results;
		
		DDGApiField field;
		
		int i = 0;
		
		if (p.nextToken() == JsonToken.START_OBJECT) {
			/*
			while (p.nextToken() != null) {
				System.out.println((++i) + p.getCurrentName());			
				p.nextToken();
			}
			
			*/
			
			while (p.nextToken() != JsonToken.END_OBJECT) {
			
				//System.out.println((++i) + p.getCurrentName());
				
				
				fName = p.getCurrentName();
				p.nextToken();
				
				System.out.println("FieldName: " + fName);
				
				try {  
					if (fName != null) {
						
						field = DDGApiField.valueOf(fName);
						
						switch (field) {
						case Abstract: 	zr.setAbstractHtml(p.getText());
						break;
						case AbstractText: zr.setAbstractText(p.getText());
						break;
						case AbstractSource: zr.setAbstractSource(p.getText());
						break;
						case AbstractURL: zr.setAbstractURL(p.getText());
						break;
						case Image: zr.setImage(p.getText());
						break;
						case Heading: zr.setHeading(p.getText());
						break;
						case Answer: zr.setAnswer(p.getText());
						break;
						case Redirect: zr.setRedirect(p.getText());
						break;
						case AnswerType: zr.setAnswerType(p.getText());
						break;
						case Definition: zr.setDefinition(p.getText());
						break;
						case DefinitionSource: zr.setDefinitionSource(p.getText());
						break;
						case DefinitionURL: zr.setDefinitionURL(p.getText());
						break;	
						case RelatedTopics: 
							
							RelatedTopic rt = new RelatedTopic();
							
							while (p.nextToken() != JsonToken.END_ARRAY) {
								
								rt = parseResultAndTopics(p);
							}
							
							//rt.setResults(results.toArray(new Result[]{}));
							//rt.setTopics(t);
							
							zr.setRelatedTopics(rt);
							
							break;	
						case Results: 
							
							results = new ArrayList<Result>();
							
							while (p.nextToken() != JsonToken.END_ARRAY) {
								System.out.println((++i) + p.getCurrentName());
								results.add(parseResult(p, new Result()));
							}
							
							zr.setResults(results);
							
							break;	
						case Type: zr.setType(p.getText());
						break;	
						}
					}
		        } catch (IllegalArgumentException e) {  
		        	System.out.println("IllegalArgumentException");
		        }  
			}
			
			
			p.close();
		}
		
		return zr;
	}
	
	private static RelatedTopic parseResultAndTopics(JsonParser p) throws Exception {
		
		RelatedTopic rt = new RelatedTopic();
		List<Topic> t = new ArrayList<Topic>();
		List<Result> r = new ArrayList<Result>();
		
		Result result = new Result();
		String sName;
		
		while (p.nextToken() != JsonToken.END_OBJECT) {
			sName = p.getCurrentName();
			result = new Result();
			
			if (sName != null) {
				
				if (sName.equals("Result")) {
					p.nextToken();
					result.setResultUrlText(p.getText());
					r.add(parseResult(p, result));
					
				} else if (sName.equals("Topics")) {
					p.nextToken();
					t.add(parseTopics(p));
					p.nextToken();
				}				
			}
		}
		
		rt.setTopics(t);
		rt.setResults(r);
		
		return rt;
	}
	
	private static Result parseResult(JsonParser p, Result r) throws Exception {
		
		String sName = "";
		
		while (p.nextToken() != JsonToken.END_OBJECT) {
			sName = p.getCurrentName();
			
			if (sName.equals("Result")) {
				p.nextToken();
				r.setResultUrlText(p.getText());
			} else if (sName.equals("FirstURL")) {
				p.nextToken();
				r.setUrl(p.getText());
			} else if (sName.equals("Text")) {
				p.nextToken();
				r.setText(p.getText());
			} else if (sName.equals("Icon")) {
				p.nextToken();
				r.setIcon(parseIcon(p));
			}
		}
		
		return r;
	}
	
	private static Icon parseIcon(JsonParser p) throws Exception {
		Icon icon = new Icon();
		String sName;
		
		while (p.nextToken() != JsonToken.END_OBJECT) {
			sName = p.getCurrentName();
			
			if (sName.equals("URL")) {
				p.nextToken();
				icon.setUrl(p.getText());
			} else if (sName.equals("Height")) {
				p.nextToken();
				icon.setHeight(p.getValueAsInt());
			} else if (sName.equals("Width")) {
				p.nextToken();
				icon.setWidth(p.getValueAsInt());
			}
		}
		
		
		return icon;
	}
	
	private static Topic parseTopics(JsonParser p) throws Exception {
		Topic t = new Topic();
		List<Result> results = new ArrayList<Result>();
		String pName;
		Result r;
		
		while (p.nextToken() != JsonToken.END_ARRAY) {
			pName = p.getCurrentName();
			
			if (pName != null && pName.equals("Result")) {
				
				r = new Result();
				p.nextToken();
				r.setResultUrlText(p.getText());
				results.add(parseResult(p, r));				
				
			}
			
		}
		
		// Next should be Topics and Name
		p.nextToken();
		p.nextToken();
		pName = p.getCurrentName();
		
		if (pName.equals("Name"))
			t.setName(p.getText());
		
		t.setResults(results);
		
		return t;
	}
}
