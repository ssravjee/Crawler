package com.web;

import static org.junit.Assert.*;

import org.junit.Test;

public class WebSpiderImplTest {

	@Test
	public void testExtractValidLinkWithDoubleQuotes() {
		WebSpider spider = new WebSpiderImpl();
		spider.extractLink("fsdfsdfsad<a href=\"http://google.co.uk\">hello</a>");
		
	}
	@Test
	public void testExtractValidLinkWithSingleQuotes() {
		WebSpider spider = new WebSpiderImpl();
		spider.extractLink("fsdfsdfsad<a href=\'http://google.co.uk\'>hello</a>");
		
	}
	@Test
	public void testExtractValidLinkWithHashMarks() {
		WebSpider spider = new WebSpiderImpl();
		spider.extractLink("fsdfsdfsad<a href=\'#wps\'>hello</a>");
		
	}
	@Test
	public void testExtractValidRelativeLink() {
		WebSpider spider = new WebSpiderImpl();
		assertEquals("/wps/public/cluk",spider.extractLink("fsdfsdfsad<a href=\'/wps/public/cluk\'>hello</a>"));
		
	}
	@Test
	public void testExtractInValidEmptyLink() {
		WebSpider spider = new WebSpiderImpl();
		assertNull(spider.extractLink("fsdfsdfsad<a href=\''>hello</a>"));
		
	}
	
	@Test
	public void testExtractMultipleValidLink() {
		WebSpider spider = new WebSpiderImpl();
		assertEquals("http://www.gmail1.com",spider.extractLink("fsdfsdfsad<a href=\'http://www.gmail1.com'>hello</a><div>fsdfsdfsad<a href=\'http://www.gmail.com'>hello</a></div>"));
		
	}
}
