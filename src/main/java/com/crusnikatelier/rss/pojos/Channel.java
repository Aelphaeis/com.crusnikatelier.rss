package com.crusnikatelier.rss.pojos;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder={
	"title",
	"link",
	"description",
	"language",
	"copyright",
	"pubDate",
	"lastBuildDate",
	"category",
	"generator",
	"docs",
	"cloud",
	"ttl",
	"image",
	"textInput",
	"skipHours",
	"skipDays",
	"managingEditor",
	"webMaster",
	"items"
})
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Channel {
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
	
	/**
	 * A string indicating the program used to generate the channel.
	 */
	private String generator;
	/**
	 * Allows processes to register with a cloud to be notified of updates to 
	 * the channel, implementing a lightweight publish-subscribe protocol for 
	 * RSS feeds.
	 */
	private Cloud cloud;
	/**
	 * ttl stands for time to live. It's a number of minutes that indicates how 
	 * long a channel can be cached before refreshing from the source. This makes 
	 * it possible for RSS sources to be managed by a file-sharing network such 
	 * as Gnutella. 
	 */
	private Integer ttl;
	/**
	 * 	Specifies a GIF, JPEG or PNG image that can be displayed with the channel
	 */
	private Image image;
	/**
	 * Specifies a text input box that can be displayed with the channel. 
	 */
	private TextInput textInput;
	/**
	 * A hint for aggregators telling them which hours they can skip
	 */
	private Integer skipHours;
	/**
	 * 	A hint for aggregators telling them which days they can skip
	 */
	private Integer skipDays;
	
	public Channel() {
		items = new ArrayList<Item>();
	}
	
	public void addItem(Item item){
		getItems().add(item);
	}

	@XmlElement(name="title")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@XmlElement(name="description")
	public String getDescription() {
		return description;
	}
	
	@XmlElement(name="link")
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

	public void setDescription(String description) {
		this.description = description;
	}

	@XmlElement(name="item")
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


}
