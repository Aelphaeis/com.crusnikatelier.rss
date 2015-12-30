package com.crusnikatelier.rss.pojos;

import com.crusnikatelier.rss.exceptions.NotImplementedException;

public class Enclosure {
	private String url;
	private String length;
	private String type;

	public Enclosure(){
		throw new NotImplementedException();
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
