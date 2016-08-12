package test.com.crusnikatelier.rss.pojos;

import static org.junit.Assert.*;

import java.net.MalformedURLException;

import org.junit.Test;
import org.w3c.dom.Element;

import com.crusnikatelier.rss.pojos.Image;

public class ImageTest {
	@Test
	public void constructorSuccessTest() {
		Image i = new Image();
		assertNotNull(i);
	}
	
	public void setHeightFailureTest(){
		Image i = new Image();
		//This is above the maximum height
		i.setHeight(500);
	}
	
	public void setWidthFailureTest(){
		Image i = new Image();
		//This is abouve the maximum Width
		i.setWidth(500);
	}
	
	public void toElementTitleFailureTest() throws MalformedURLException{
		Image i = new Image();
		i.setLink("http://www.google.com");
		i.setUrl("http://www.google.com");
	}
	
	public void toElementLinkFailureTest() throws MalformedURLException{
		Image i = new Image();
		i.setTitle("My Title");
		i.setUrl("http://www.google.com");
	}
	
	public void toElementUrlFailureTest() throws MalformedURLException{
		Image i = new Image();
		i.setTitle("My Title");
		i.setLink("http://www.google.com");
	}
	
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
	}
	
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
	}
	
	@Test
	public void toElementSuccessTest() throws MalformedURLException{
		Image i = new Image();
		i.setTitle("My Title");
		i.setLink("http://www.google.com");
		i.setUrl("http://www.google.com");
	}
}
