package com.crusnikatelier.rss.pojos;

import com.crusnikatelier.rss.exceptions.NotImplementedException;

public class Category {
	

	private String domain;
	private String category;
	
	public Category(){
		throw new NotImplementedException();
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
}
