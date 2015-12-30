package com.crusnikatelier.rss.pojos;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.crusnikatelier.rss.exceptions.SyndicationSyntaxException;

public class Channel extends RSSElement {
	//Mandatory Channel elements
	private String title;
	private URL link;
	private String description;
	

	//Optional Channel Elements
	private List<Item> items;

	private String language;
	private String copyright;
	private String managingEditor;
	private String webMaster;
	private Date pubDate;
	private Date lastBuildDate;
	private String category;
	private String docs;
	
	private String generator;
	private Cloud cloud;
	private Integer ttl;
	private Image image;
	private TextInput textInput;
	private Integer skipHours;
	private Integer skipDays;
	
	public Channel() {
		items = new ArrayList<Item>();
	}

	@Override
	protected void Validate() {
		if(getTitle() == null){
			String errMsg = "Title must have a value";
			throw new SyndicationSyntaxException(errMsg);
		}
		
		if(getLink() == null){
			String errMsg = "Link must have a value";
			throw new SyndicationSyntaxException(errMsg);
		}
		
		if(getDescription() == null){
			String errMsg = "Description must have a value";
			throw new SyndicationSyntaxException(errMsg);
		}
		
		for(Item item : getItems() == null? new ArrayList<Item>() : getItems() )
			item.Validate();

		if(getImage() != null){
			getImage().Validate();
		}
	}
	
	@Override
	public Element toElement() {
		Document doc = createEmptyDocument();
		Element element = doc.createElement("channel");
		
		Validate();
		
		AugmentElement(element, "title", getTitle());
		AugmentElement(element, "link", getLink());
		AugmentElement(element, "description", getDescription());
		
		AugmentElement(element, "language", getLanguage());
		AugmentElement(element, "copyright", getCopyright());
		AugmentElement(element, "managingEditor", getManagingEditor());
		AugmentElement(element, "webMaster", getWebMaster());
		AugmentElement(element, "pubDate", getPubDate());
		AugmentElement(element, "lastBuildDate", getLastBuildDate());
		AugmentElement(element, "category", getCategory());
		AugmentElement(element, "docs", getDocs());
		AugmentElement(element, "generator", getGenerator());
		AugmentElement(element, "cloud", getCloud());
		AugmentElement(element, "ttl", getTtl());
		AugmentElement(element, "image", getImage());
		AugmentElement(element, "textInput", getTextInput());
		AugmentElement(element, "skipHours", getSkipHours());
		AugmentElement(element, "skipDays", getSkipDays());
		
		for(Item it :  getItems() == null? new ArrayList<Item>() : getItems() )
			AugmentElement(element, "item", it);
		
		return element;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getCopyright() {
		return copyright;
	}

	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}

	public String getManagingEditor() {
		return managingEditor;
	}

	public void setManagingEditor(String managingEditor) {
		this.managingEditor = managingEditor;
	}

	public String getWebMaster() {
		return webMaster;
	}

	public void setWebMaster(String webMaster) {
		this.webMaster = webMaster;
	}

	public Date getPubDate() {
		return pubDate;
	}

	public void setPubDate(Date pubDate) {
		this.pubDate = pubDate;
	}

	public Date getLastBuildDate() {
		return lastBuildDate;
	}

	public void setLastBuildDate(Date lastBuildDate) {
		this.lastBuildDate = lastBuildDate;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDocs() {
		return docs;
	}

	public void setDocs(String docs) {
		this.docs = docs;
	}

	public String getGenerator() {
		return generator;
	}

	public void setGenerator(String generator) {
		this.generator = generator;
	}

	public Cloud getCloud() {
		return cloud;
	}

	public void setCloud(Cloud cloud) {
		this.cloud = cloud;
	}

	public Integer getTtl() {
		return ttl;
	}

	public void setTtl(Integer ttl) {
		this.ttl = ttl;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public TextInput getTextInput() {
		return textInput;
	}

	public void setTextInput(TextInput textInput) {
		this.textInput = textInput;
	}

	public Integer getSkipHours() {
		return skipHours;
	}

	public void setSkipHours(Integer skipHours) {
		this.skipHours = skipHours;
	}

	public Integer getSkipDays() {
		return skipDays;
	}

	public void setSkipDays(Integer skipDays) {
		this.skipDays = skipDays;
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
}
