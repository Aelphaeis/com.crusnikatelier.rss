package test.com.crusnikatelier.rss.pojos;

import static org.junit.Assert.*;

import java.net.MalformedURLException;

import org.junit.Before;
import org.junit.Test;
import org.xml.sax.SAXException;

import com.crusnikatelier.rss.Channel;
import com.crusnikatelier.rss.Image;
import com.crusnikatelier.rss.RSS;

public class ImageTest {
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
	
	
	@Test
	public void constructorSuccessTest() {
		Image i = new Image();
		assertNotNull(i);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void setHeightFailureTest(){
		Image i = new Image();
		//This is above the maximum height
		i.setHeight(500);
		
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void setWidthFailureTest(){
		Image i = new Image();
		//This is above the maximum Width
		i.setWidth(500);
	}
	
	@Test(expected=SAXException.class)
	public void toElementTitleFailureTest() throws MalformedURLException, SAXException{
		Image i = new Image();
		i.setLink("http://www.google.com");
		i.setUrl("http://www.google.com");
		rss.getChannel().setImage(i);
		rss.validate();
	}
	
	@Test(expected=SAXException.class)
	public void toElementLinkFailureTest() throws MalformedURLException, SAXException{
		Image i = new Image();
		i.setTitle("My Title");
		i.setUrl("http://www.google.com");
		rss.getChannel().setImage(i);
		rss.validate();
	}
	
	@Test(expected=SAXException.class)
	public void toElementUrlFailureTest() throws MalformedURLException, SAXException{
		Image i = new Image();
		i.setTitle("My Title");
		i.setLink("http://www.google.com");
		rss.getChannel().setImage(i);
		rss.validate();
	}
	
	@Test(expected=SAXException.class)
	public void toElementHeightFailureTest() throws MalformedURLException, SAXException{
		//Use inheritance to by pass setting limitations
		Image i = new Image(){
			@Override
			public int getHeight(){
				return 500; 
			}
		};
		
		i.setTitle("My Title");
		i.setLink("http://www.google.com");
		i.setUrl("http://www.google.com");
		
		rss.getChannel().setImage(i);
		rss.validate();
	}
	
	@Test(expected=SAXException.class)
	public void toElementWidthFailureTest() throws MalformedURLException, SAXException{
		//Use inheritance to by pass setting limitations
		Image i = new Image(){
			@Override
			public int getWidth(){
				return 500; 
			}
		};
		
		i.setTitle("My Title");
		i.setLink("http://www.google.com");
		i.setUrl("http://www.google.com");
		
		rss.getChannel().setImage(i);
		rss.validate();
	}
	
	@Test
	public void toElementSuccessTest() throws MalformedURLException, SAXException{
		Image i = new Image();
		i.setTitle("My Title");
		i.setLink("http://www.google.com");
		i.setUrl("http://www.google.com");
		
		rss.getChannel().setImage(i);
		rss.validate();
	}
}
