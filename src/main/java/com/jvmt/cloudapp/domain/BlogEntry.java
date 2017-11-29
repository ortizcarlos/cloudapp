package com.jvmt.cloudapp.domain;

import java.util.Date;
import java.util.UUID;

public class BlogEntry {
	private String title;
	private String content;
	private Date created;
	private String id;
	
	
	
	public BlogEntry(String title, String content) {
		super();
		this.title = title;
		this.content = content;
		this.created = new Date();
		this.id = UUID.randomUUID().toString();
		
	}

	public String getContent() {
		return content;
	}
	
	public String getTitle() {
		return title;
	}
}
