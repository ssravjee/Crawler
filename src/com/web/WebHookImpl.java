package com.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

public class WebHookImpl implements WebHook {

	@Override
	public String getConnection(String domain) {
		StringBuilder sb = new StringBuilder();
		try {
			URL url = new URL(domain);
			InputStream inputStream = (InputStream) url.getContent();
			BufferedReader breader = new BufferedReader(new InputStreamReader(inputStream));
			String line = "";
			while((line = breader.readLine() ) !=null) {
				sb.append(line);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sb.toString();
	}

	@Override
	public void displayAbsoluteLinks(List<String> links, String domain) {
		for (Iterator iterator = links.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			if(string.startsWith("/") || string.startsWith("#")) {
				string = domain + string;
			}
			System.out.println(string);
		}
		
	}

}
