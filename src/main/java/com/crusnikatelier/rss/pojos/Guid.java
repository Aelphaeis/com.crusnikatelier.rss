package com.crusnikatelier.rss.pojos;

import com.crusnikatelier.rss.exceptions.NotImplementedException;

public class Guid {
	private String guid;
	private boolean isPermaLink;

	public Guid(){
		throw new NotImplementedException();
	}

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public boolean isPermaLink() {
		return isPermaLink;
	}

	public void setPermaLink(boolean isPermaLink) {
		this.isPermaLink = isPermaLink;
	}
}
