package com.web;

import java.util.ArrayList;
import java.util.List;

public class WebSpiderImpl implements WebSpider {
	private static final String HTML_A_HREF_TAG = "<a href=";
	List<String> links = null;
	public WebSpiderImpl() {
		links = new ArrayList<String>();
	}
	@Override
	public List<String> extractLink(String content) {
		String link = "";
		if (null == content || content.isEmpty()) {
			return null;
		}
		
		int aHrefTagstartIndex = content.indexOf(HTML_A_HREF_TAG);
		if(aHrefTagstartIndex == -1) {
			return null;
		}
		int quoteLocation = aHrefTagstartIndex + HTML_A_HREF_TAG.length();
		String quote = content.substring(quoteLocation, quoteLocation+1);
		link = content.substring(quoteLocation+ 1);//temp link
		link = link.substring(0, link.indexOf(quote));
		//if link start with / or # then make it absolute
		links.add(link);
		
		extractLink(content.substring(quoteLocation+ 1, content.length()));
		
		return links;
	}
	

}

