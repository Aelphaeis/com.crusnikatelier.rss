package com.crusnikatelier.rss.pojos;

import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
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

@XmlRootElement(name="rss")
public class RSS extends RSSElement {
	public static final String DEFAULT_VERSION = "2.0";
	public static final String ATOM_NAMESPACE = "http://www.w3.org/2005/Atom";
	public static final String ATOM_PREFIX = "atom";
	
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
		
		ch.Validate();
	}
	
	public Element toElement(){
		Document doc = createEmptyDocument();
		Element element = doc.createElement("rss");
		
		Validate();
		
		element.setAttribute("version", getVersion());
		AugmentElement(element, "channel", getChannel());
		
		return element;
	}
		
	public static Document toDocument(RSS rss) throws JAXBException, ParserConfigurationException{
		JAXBContext context = JAXBContext.newInstance(rss.getClass());
		Marshaller marshaller = context.createMarshaller();
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document document = db.newDocument();
		
		marshaller.marshal(rss, document);
		return document;
	}
	

	@Override
	public String toString(){
		try{
			TransformerFactory transFactory = TransformerFactory.newInstance();
			Transformer transformer = transFactory.newTransformer();
			StringWriter buffer = new StringWriter();
			Node n = toDocument(this);
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

	@XmlAttribute(name="version")
	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	@XmlElement
	public Channel getChannel() {
		return channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}
	
}
