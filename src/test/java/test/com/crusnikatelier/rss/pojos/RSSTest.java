package test.com.crusnikatelier.rss.pojos;

import static org.junit.Assert.*;

import java.net.MalformedURLException;

import com.crusnikatelier.rss.pojos.Channel;
import com.crusnikatelier.rss.pojos.RSS;

import org.junit.Test;
import org.xml.sax.SAXException;

public class RSSTest {
 
	@Test
	public void constructorSuccessTest() {
		RSS rss = new RSS();
		assertNotNull(rss);
	}
	@Test(expected=SAXException.class)
	public void validateNoChannelFailureTest() throws SAXException{
		RSS rss = new RSS();
		rss.validate();
	}
	
	@Test(expected=SAXException.class)
	public void validateInvalidChannelFailureTest() throws SAXException{
		RSS rss = new RSS();
		rss.setChannel(new Channel());
		rss.validate();
	}
	
	@Test
	public void validateSuccessTest() throws SAXException, MalformedURLException{
		RSS rss = new RSS();
		// rss feed must have a channel element
		rss.setChannel(new Channel());
		
		//channel elements must have a title, description and link
		rss.getChannel().setTitle("My Title");
		rss.getChannel().setLink("http://www.google.com");
		rss.getChannel().setDescription("My Description");
		
		rss.validate();
	}
	
}
