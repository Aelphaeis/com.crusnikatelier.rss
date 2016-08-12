package test.com.crusnikatelier.rss.pojos;

import static org.junit.Assert.*;

import java.net.MalformedURLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.xml.sax.SAXException;

import com.crusnikatelier.rss.pojos.Channel;
import com.crusnikatelier.rss.pojos.Item;
import com.crusnikatelier.rss.pojos.RSS;

public class ItemTest {

	RSS rss;
	
	@Before
	public void setup() throws MalformedURLException{
		rss = new RSS();
		
		Channel chan = new Channel();
		chan.setTitle("My Title");
		chan.setLink("http://www.google.com");
		chan.setDescription("My Description");
		rss.setChannel(chan);
	}
	
	@After
	public void cleanup(){
		rss = null;
	}
	
	@Test
	public void constructorSuccessTest() {
		Item i = new Item();
		assertNotNull(i);
	}
	
	@Test(expected=SAXException.class)
	public void toElementInvalidTitleFailureTest() throws SAXException{
		Item i = new Item();
		rss.getChannel().addItem(i);
		rss.validate();
	}
	
	@Test
	public void toElementTitleSuccessTest() throws SAXException{
		Item i = new Item();
		i.setTitle("My Title");
		rss.getChannel().addItem(i);
		rss.validate();
	}
	
	@Test
	public void toElementDescriptionSucceessTest() throws SAXException{
		Item i = new Item();
		i.setDescription("My Description");
		rss.getChannel().addItem(i);
		rss.validate();
	}
	
	@Test
	public void toElementDescriptionTitleSucceessTest() throws SAXException{
		Item i = new Item();
		i.setTitle("My Title");
		i.setDescription("My Description");
		rss.getChannel().addItem(i);
		rss.validate();
	}
}
