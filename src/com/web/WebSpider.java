package com.web;

import java.util.List;

public interface WebSpider {
	public List<String> extractLink(String content);
	
}
