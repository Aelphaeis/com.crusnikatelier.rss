package com.crusnikatelier.rss;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder={
	"url",
	"title",
	"link",
	"width",
	"height",
	"description"
})
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Image  {
	
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
	
	public Image(){
		setHeight(DEFAULT_HEIGHT);
		setWidth(DEFAULT_WIDTH);
	}

	@XmlElement
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
	
	@XmlElement
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@XmlElement
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

	@XmlElement
	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		if(height > MAX_HEIGHT){
			String errMsg = "Height cannot exceed " + MAX_HEIGHT;
			throw new IllegalArgumentException(errMsg);
		}
		this.height = height;
	}

	@XmlElement
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		if(width > MAX_WIDTH){
			String errMsg = "Width cannot exceed " + MAX_WIDTH;
			throw new IllegalArgumentException(errMsg);
		}
		this.width = width;
	}

	@XmlElement
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
