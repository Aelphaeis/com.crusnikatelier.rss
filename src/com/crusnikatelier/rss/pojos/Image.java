package com.crusnikatelier.rss.pojos;

import java.net.MalformedURLException;
import java.net.URL;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.crusnikatelier.rss.exceptions.SyndicationSyntaxException;

public class Image extends RSSElement {
	
	public static final int MAX_WIDTH = 144;
	public static final int MAX_HEIGHT = 400;
	public static final int DEFAULT_HEIGHT = 31;
	public static final int DEFAULT_WIDTH = 88;
	
	//Mandatory Elements
	private URL url;
	private String title;
	private URL link;
	
	//Optional Elements
	private int height;
	private int width;
	private String description;
	
	@Override
	public void Validate(){
		if(getTitle() == null){
			String errMsg = "Title must have a value";
			throw new SyndicationSyntaxException(errMsg);
		}
		if(getUrl() == null){
			String errMsg ="url must have a value"; 
			throw new SyndicationSyntaxException(errMsg);
		}
		if(getLink() == null){
			String errMsg = "link must have a value";
			throw new SyndicationSyntaxException(errMsg);
		}
		
		if(getHeight() > MAX_HEIGHT){
			String errMsg = "Height cannot exceed " + MAX_HEIGHT;
			throw new SyndicationSyntaxException(errMsg);
		}
		
		if(getWidth() > MAX_WIDTH){
			String errMsg = "Width cannot exceed " + MAX_WIDTH;
			throw new SyndicationSyntaxException(errMsg);
		}
	}
	
	@Override
	public Element toElement() {
		Document doc = createEmptyDocument();
		Element element = doc.createElement("image");
		
		Validate();
		
		AugmentElement(element, "url", getUrl());
		AugmentElement(element, "title", getTitle());
		AugmentElement(element, "link", getLink());
		
		
		AugmentElement(element, "height", getHeight());
		AugmentElement(element, "width", getWidth());
		AugmentElement(element, "description", getDescription());
		
		return element;
	}
	

	public URL getUrl() {
		return url;
	}

	public void setUrl(String url) throws MalformedURLException {
		//Exception throws because error is recoverable
		setUrl(new URL(url));
	}
	
	public void setUrl(URL url)  {
		this.url = url;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public URL getLink() {
		return link;
	}

	public void setLink(URL link) {
		this.link = link;
	}
	
	public void setLink(String link) throws MalformedURLException{
		//Exception throws because error is recoverable
		this.link = new URL(link);
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		if(height > MAX_HEIGHT){
			String errMsg = "Height cannot exceed " + MAX_HEIGHT;
			throw new SyndicationSyntaxException(errMsg);
		}
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		if(width > MAX_WIDTH){
			String errMsg = "Width cannot exceed " + MAX_WIDTH;
			throw new SyndicationSyntaxException(errMsg);
		}
		this.width = width;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}



}
