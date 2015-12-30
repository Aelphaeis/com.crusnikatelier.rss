package com.crusnikatelier.rss.pojos;

import com.crusnikatelier.rss.exceptions.NotImplementedException;

public class Source {
	private String url;
	private String source;
	
	public Source(){
		throw new NotImplementedException();
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}
}
