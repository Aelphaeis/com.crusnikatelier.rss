package test.com.crusnikatelier.rss.pojos;

import static org.junit.Assert.*;

import java.net.MalformedURLException;

import com.crusnikatelier.rss.exceptions.SyndicationSyntaxException;
import com.crusnikatelier.rss.pojos.Channel;
import com.crusnikatelier.rss.pojos.RSS;

import org.junit.Test;

public class RSSTest {

	@Test
	public void constructorSuccessTest() {
		RSS rss = new RSS();
		assertNotNull(rss);
	}
	
	@Test(expected=SyndicationSyntaxException.class)
	public void ToDocumentExceptionTest(){
		RSS rss = new RSS();
		rss.toDocument();
	}
	
	@Test
	public void ToDocumentSuccessTest() throws MalformedURLException{
		RSS rss = new RSS();
		
		// rss feed must have a channel element
		rss.setChannel(new Channel());
		
		
		//channel elements must have a title, description and link
		rss.getChannel().setTitle("My Title");
		rss.getChannel().setLink("http://www.google.com");
		rss.getChannel().setDescription("My Description");
		
		//Test the toDocument method
		rss.toDocument();
	}
	
}
