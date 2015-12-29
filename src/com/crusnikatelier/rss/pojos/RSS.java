package com.crusnikatelier.rss.pojos;

import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import com.crusnikatelier.rss.exceptions.SyndicationSyntaxException;

public class RSS extends RSSElement {
	public final String DEFAULT_VERSION = "2.0";
	public final String ATOM_NAMESPACE = "http://www.w3.org/2005/Atom";
	public final String ATOM_PREFIX = "atom";
	
	private String version;	
	private Channel channel;
	
	public RSS(){
		version = DEFAULT_VERSION;
	}
	

	@Override
	protected void Validate() {
		Channel ch = getChannel();
		if(ch == null){
			String errMsg = "rss must have a channel element";
			throw new SyndicationSyntaxException(errMsg);
		}
	}
	
	public Element toElement(){
		Document doc = createEmptyDocument();
		Element element = doc.createElement("rss");
		
		Validate();
		
		element.setAttribute("version", getVersion());
		AugmentElement(element, "channel", getChannel());
		
		return element;
	}
	
	/**
	 * Used to convert this object into an RSS feed document
	 * @return Representation of this object in XML 
	 * @throws SyndicationSyntaxException If no channel is specified
	 */
	public Document toDocument() throws SyndicationSyntaxException {
		try{
			Validate();
			
			DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
			Document doc = docBuilder.newDocument();
			
			Element element = doc.createElement("rss");
			
			element.setAttribute("version", getVersion());
			AugmentElement(element, "channel", getChannel());
			
			doc.appendChild(element);
			
			return doc;
		}
		catch(ParserConfigurationException pce){
			//If this occurs this is is a non recoverable error
			throw new RuntimeException(pce);
		}
	}
	

	@Override
	public String toString(){
		try{
			TransformerFactory transFactory = TransformerFactory.newInstance();
			Transformer transformer = transFactory.newTransformer();
			StringWriter buffer = new StringWriter();
			Node n = toDocument();
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			
			transformer.transform(new DOMSource(n), new StreamResult(buffer));
			return buffer.toString();
		}
		catch(Throwable t){
			//We want to stop all exceptions
			//throw new RuntimeException(t);
			return super.toString();
		}
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public Channel getChannel() {
		return channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}
}
