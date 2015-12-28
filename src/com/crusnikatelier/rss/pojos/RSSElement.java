package com.crusnikatelier.rss.pojos;

import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public abstract class RSSElement implements RSSElementContract {

	@Override
	public String toString(){
		try{
			TransformerFactory transFactory = TransformerFactory.newInstance();
			Transformer transformer = transFactory.newTransformer();
			StringWriter buffer = new StringWriter();
			Node n = toElement();
			
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
			transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			
			transformer.transform(new DOMSource(n), new StreamResult(buffer));
			return buffer.toString();
		}
		catch(Throwable t){
			throw new RuntimeException(t);
		}
	}
	
	public boolean isValid(){
		try{
			Validate();
			return true;
		}
		catch(Exception e){
			return false;
		}
	}
	
	protected static Document createEmptyDocument(){
		try{
			DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
			Document doc = docBuilder.newDocument();
			return doc;
		}
		catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	
	protected static Element AugmentElement(Element parent, String nodeName, Object value){
		if(value == null)
			return parent;
		
		if(value instanceof RSSElementContract){
			Document doc = parent.getOwnerDocument();
			
			RSSElementContract e = (RSSElementContract) value;
			Node n = doc.importNode(e.toElement(), true);
			parent.appendChild(n);
			return parent;
		}
		else{
			Document doc = parent.getOwnerDocument();
			Element child = doc.createElement(nodeName);
			child.setTextContent(value.toString());
			parent.appendChild(child);
			return parent;
		}
	}
	
	protected abstract void Validate();

}
