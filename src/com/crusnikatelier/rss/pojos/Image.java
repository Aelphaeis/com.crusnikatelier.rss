package com.crusnikatelier.rss.pojos;

public abstract class Image {
	
	public final int MAX_WIDTH = 144;
	public final int MAX_HEIGHT = 400;
	public final int DEFAULT_HEIGHT = 31;
	public final int DEFAULT_WIDTH = 88;
	
	private String url;
	private String title;
	private String link;
	private int height;
	private int width;
	private String description;
}
