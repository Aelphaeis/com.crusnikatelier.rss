package test.com.crusnikatelier.rss.pojos;

import static org.junit.Assert.*;

import java.net.MalformedURLException;

import org.junit.Test;

import com.crusnikatelier.rss.exceptions.SyndicationSyntaxException;
import com.crusnikatelier.rss.pojos.Channel;
import com.crusnikatelier.rss.pojos.Image;
import com.crusnikatelier.rss.pojos.Item;

public class ChannelTest {

	@Test
	public void ConstructorSuccessTest() {
		Channel chan = new Channel();
		assertNotNull(chan);
	}
	
	@Test(expected=SyndicationSyntaxException.class)
	public void toElementTitleFailureTest() throws MalformedURLException{
		Channel chan = new Channel();
		chan.setLink("http://www.google.com");
		chan.setDescription("My Description");
		//chan.toElement();
	}
	

	@Test(expected=SyndicationSyntaxException.class)
	public void toElementLinkFailureTest(){
		Channel chan = new Channel();
		chan.setTitle("My Title");
		chan.setDescription("My Description");
		//chan.toElement();
	}
	
	@Test(expected=SyndicationSyntaxException.class)
	public void toElementDescFailureTest() throws MalformedURLException{
		Channel chan = new Channel();
		chan.setTitle("My Title");
		chan.setLink("http://www.google.com");
		//chan.toElement();
	}
	
	@Test(expected=SyndicationSyntaxException.class)
	public void toElementInvalidChildFailure() throws MalformedURLException{
		Channel chan = new Channel();
		Item i = new Item();
		
		chan.setTitle("My Title");
		chan.setLink("http://www.google.com");
		chan.setDescription("My Description");
		chan.getItems().add(i);
		
		//chan.toElement();
	}
	
	@Test(expected=SyndicationSyntaxException.class)
	public void toElementInvalidImageFailure() throws MalformedURLException{
		Channel chan = new Channel();
		chan.setTitle("My Title");
		chan.setLink("http://www.google.com");
		//chan.toElement();
		
		chan.setImage(new Image());
		//The title is missing
		chan.getImage().setUrl("http://www.google.com");
		chan.getImage().setLink("http://www.google.com");
		
		//chan.toElement();
	}
	
	public void toElementSuccessTest() throws MalformedURLException{
		Channel chan = new Channel();
		chan.setTitle("My Title");
		chan.setLink("http://www.google.com");
		chan.setDescription("My Description");
		//chan.toElement();
		assertNotNull(chan);
	}
}
