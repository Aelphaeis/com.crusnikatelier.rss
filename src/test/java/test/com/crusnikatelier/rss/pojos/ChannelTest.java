package test.com.crusnikatelier.rss.pojos;

import static org.junit.Assert.*;

import java.net.MalformedURLException;

import org.junit.Before;
import org.junit.Test;
import org.xml.sax.SAXException;

import com.crusnikatelier.rss.pojos.Channel;
import com.crusnikatelier.rss.pojos.RSS;

public class ChannelTest {

	RSS rss;
	
	@Before
	public void setup(){
		rss = new RSS();
	}
	
	@Test
	public void ConstructorSuccessTest() {
		Channel chan = new Channel();
		assertNotNull(chan);
	}
	
	@Test(expected=SAXException.class)
	public void validateTitleFailureTest() throws MalformedURLException, SAXException{
		Channel chan = new Channel();
		chan.setLink("http://www.google.com");
		chan.setDescription("My Description");
		
		rss.setChannel(chan);
		rss.validate();
	}
	

	@Test(expected=SAXException.class)
	public void toElementLinkFailureTest() throws SAXException{
		Channel chan = new Channel();
		chan.setTitle("My Title");
		chan.setDescription("My Description");
		
		rss.setChannel(chan);
		rss.validate();
	}
	
	@Test(expected=SAXException.class)
	public void toElementDescFailureTest() throws MalformedURLException, SAXException{
		Channel chan = new Channel();
		chan.setTitle("My Title");
		chan.setLink("http://www.google.com");
		
		rss.setChannel(chan);
		rss.validate();
	}
	
	@Test
	public void toElementSuccessTest() throws MalformedURLException, SAXException{
		Channel chan = new Channel();
		chan.setTitle("My Title");
		chan.setLink("http://www.google.com");
		chan.setDescription("My Description");
		
		rss.setChannel(chan);
		rss.validate();
	}
}
