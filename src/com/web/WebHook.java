package com.web;

import java.util.List;


public interface WebHook {
	public String getConnection(String URL);
	public void displayAbsoluteLinks(List<String> links, String domain);
}
