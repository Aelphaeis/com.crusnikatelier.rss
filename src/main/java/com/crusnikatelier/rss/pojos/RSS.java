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
	
	private static final String W3C_XML_SCHEMA_NAMESPACE_URI = "http://www.w3.org/2001/XMLSchema";
	
	private String version;	
	private Channel channel;
	
	public RSS(){
		version = DEFAULT_VERSION;
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
	
	public static void validate(RSS rss) throws JAXBException, ParserConfigurationException, SAXException, IOException{
		//Get XML and XSD document
		Document document = toDocument(rss);
		ClassLoader loader = RSS.class.getClassLoader();
		File xsdFile = new File(loader.getResource("Rss2-0.xsd").getFile());
		
		//Turn XSD into validator
		SchemaFactory sFactory = SchemaFactory.newInstance(W3C_XML_SCHEMA_NAMESPACE_URI);
		Validator validator = sFactory.newSchema(new StreamSource(xsdFile)).newValidator();
		
		//Validate document with XSD
		DOMSource docAdapter = new DOMSource(document);
		validator.validate(docAdapter);
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
