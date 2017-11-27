package com.jvmt.cloudapp.domain;

public class BlogEntry {
	private String title;
	private String content;
	
	
	
	public BlogEntry(String title, String content) {
		super();
		this.title = title;
		this.content = content;
	}

	public String getContent() {
		return content;
	}
	
	public String getTitle() {
		return title;
	}
}
