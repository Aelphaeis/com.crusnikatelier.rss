package test.com.crusnikatelier.rss.pojos;

import static org.junit.Assert.*;

import java.net.MalformedURLException;

import org.junit.Test;
import org.w3c.dom.Element;

import com.crusnikatelier.rss.exceptions.SyndicationSyntaxException;
import com.crusnikatelier.rss.pojos.Image;

public class ImageTest {
	@Test
	public void constructorSuccessTest() {
		Image i = new Image();
		assertNotNull(i);
	}
	
	@Test(expected=SyndicationSyntaxException.class) 
	public void setHeightFailureTest(){
		Image i = new Image();
		//This is above the maximum height
		i.setHeight(500);
	}
	
	@Test(expected=SyndicationSyntaxException.class)
	public void setWidthFailureTest(){
		Image i = new Image();
		//This is abouve the maximum Width
		i.setWidth(500);
	}
	
	@Test(expected=SyndicationSyntaxException.class)
	public void toElementTitleFailureTest() throws MalformedURLException{
		Image i = new Image();
		i.setLink("http://www.google.com");
		i.setUrl("http://www.google.com");
		i.toElement();
	}
	
	@Test(expected=SyndicationSyntaxException.class)
	public void toElementLinkFailureTest() throws MalformedURLException{
		Image i = new Image();
		i.setTitle("My Title");
		i.setUrl("http://www.google.com");
		i.toElement();
	}
	
	@Test(expected=SyndicationSyntaxException.class)
	public void toElementUrlFailureTest() throws MalformedURLException{
		Image i = new Image();
		i.setTitle("My Title");
		i.setLink("http://www.google.com");
		i.toElement();
	}
	
	@Test(expected=SyndicationSyntaxException.class)
	public void toElementHeightFailureTest() throws MalformedURLException{
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
		i.toElement();
	}
	
	@Test(expected=SyndicationSyntaxException.class)
	public void toElementWidthFailureTest() throws MalformedURLException{
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
		i.toElement();
	}
	
	@Test
	public void toElementSuccessTest() throws MalformedURLException{
		Image i = new Image();
		i.setTitle("My Title");
		i.setLink("http://www.google.com");
		i.setUrl("http://www.google.com");
		Element e = i.toElement();
		assertNotNull(e);
	}
}
