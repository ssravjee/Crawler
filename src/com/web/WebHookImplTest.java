package com.web;

import java.util.List;

import org.junit.Test;

public class WebHookImplTest {

	@Test
	public void testGetConnection() {
		WebHook hook = new WebHookImpl();
		String domain = "http://ifazone.canadalife.co.uk/public/wps/portal/cluk";//"http://google.co.uk";
		String content = hook.getConnection(domain);
		System.out.println("\n\n" + " ------------ CONTENT --------------" + "\n\n" + 
										content 
		+ "\n\n" + " ------------ CONTENT --------------" + "\n\n");
		
		WebSpider spider = new WebSpiderImpl();
		List<String> links = spider.extractLink(content);
		hook.displayAbsoluteLinks(links, domain);
		}
	}
