package com.crusnikatelier.rss.pojos;

import java.util.Date;

import org.w3c.dom.Element;
import org.w3c.dom.Document;

import com.crusnikatelier.rss.exceptions.SyndicationSyntaxException;

public class Item extends RSSElement {
	
	//SemiMandatory
	private String title;
	private String description;
	
	//Optional
	private String link;
	private String author;
	private String category;
	private String comments;
	private Enclosure enclosure;
	private Guid guid;
	private Date pubDate;
	private Source source;
	
	@Override
	protected void Validate(){
		if(getTitle() == null && getDescription() == null){
			String err = "Title and Description cannot both be null";
			throw new SyndicationSyntaxException(err);
		}
	}
	
	public Element toElement(){
		Document doc = createEmptyDocument();
		Element element = doc.createElement("item");	
		
		Validate();

		AugmentElement(element, "title", getTitle());
		AugmentElement(element, "description", getDescription());
		
		AugmentElement(element, "link", getLink());
		AugmentElement(element, "author", getAuthor());
		AugmentElement(element, "category", getCategory());
		AugmentElement(element, "comments", getComments());
		AugmentElement(element, "enclosure",getEnclosure());
		AugmentElement(element, "guid", getGuid());
		AugmentElement(element, "pubDate", getPubDate());
		AugmentElement(element, "source", getSource());
		
		return element;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Enclosure getEnclosure() {
		return enclosure;
	}

	public void setEnclosure(Enclosure enclosure) {
		this.enclosure = enclosure;
	}

	public Guid getGuid() {
		return guid;
	}

	public void setGuid(Guid guid) {
		this.guid = guid;
	}

	public Date getPubDate() {
		return pubDate;
	}

	public void setPubDate(Date pubDate) {
		this.pubDate = pubDate;
	}

	public Source getSource() {
		return source;
	}

	public void setSource(Source source) {
		this.source = source;
	}
}
