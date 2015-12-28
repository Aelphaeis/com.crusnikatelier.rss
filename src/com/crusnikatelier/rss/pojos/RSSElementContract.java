package com.crusnikatelier.rss.pojos;

import org.w3c.dom.Element;

interface RSSElementContract {
	boolean isValid();
	Element toElement();
}
