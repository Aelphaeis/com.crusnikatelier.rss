package com.crusnikatelier.rss.pojos;

import java.io.File;
import java.io.IOException;
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
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;


@XmlRootElement(name="rss")
public class RSS  {
	public static final String DEFAULT_VERSION = "2.0";
	public static final String ATOM_NAMESPACE = "http://www.w3.org/2005/Atom";
	public static final String ATOM_PREFIX = "atom";
	
	public static Document toDocument(RSS rss){
		
		Marshaller marshaller = null;
		Document document = null;
		try{
			JAXBContext context = JAXBContext.newInstance(RSS.class);
			marshaller = context.createMarshaller();
			
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			document = db.newDocument();
			
			marshaller.marshal(rss, document);
			
			return document;
		}
		catch (JAXBException e) {
			//Should really not occur since we control all objects
			throw new IllegalStateException(e);
		} 
		catch (ParserConfigurationException e) {
			//Should not occur since we control the Object we're writing
			throw new IllegalStateException(e);
		}
	}
	
	public static void validate(RSS rss) throws SAXException {
		Validator validator = null;
		DOMSource docAdapter = null;
		//Get XML and XSD document
		try{
			Document document = toDocument(rss);
			ClassLoader loader = RSS.class.getClassLoader();
			File xsdFile = new File(loader.getResource("Rss2-0.xsd").getFile());
			
			//Turn XSD into validator
			SchemaFactory sFactory = SchemaFactory.newInstance(W3C_XML_SCHEMA_NAMESPACE_URI);
			validator = sFactory.newSchema(new StreamSource(xsdFile)).newValidator();
			
			//Validate document with XSD
			docAdapter = new DOMSource(document);
		}
		catch (SAXException e) {
			e.printStackTrace();
		}
		try {
			validator.validate(docAdapter);
		} 
		catch (IOException e) {
			//Should not occur
			e.printStackTrace();
		}
	}
	
	private static final String W3C_XML_SCHEMA_NAMESPACE_URI = "http://www.w3.org/2001/XMLSchema";
	
	private String version;	
	private Channel channel;
	
	public RSS(){
		version = DEFAULT_VERSION;
	}
		
	@XmlAttribute(name="version")
	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	@XmlElement(name="channel")
	public Channel getChannel() {
		return channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
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
}
