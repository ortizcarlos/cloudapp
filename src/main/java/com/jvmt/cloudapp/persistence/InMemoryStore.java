package com.jvmt.cloudapp.persistence;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Component;

import com.jvmt.cloudapp.domain.BlogEntry;

@Component
public class InMemoryStore {
	private List<BlogEntry> store;
	
	public InMemoryStore() {
		store = new ArrayList<BlogEntry>();
	}
	
	public void saveBlogEntry(BlogEntry blogEntry) {
		store.add(blogEntry);
	}
	
	public List<BlogEntry> listAll() {
		return  Collections.unmodifiableList(store);
	}
}
