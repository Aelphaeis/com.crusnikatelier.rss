package test.com.crusnikatelier.rss.pojos;

import static org.junit.Assert.*;

import org.junit.Test;

import com.crusnikatelier.rss.exceptions.SyndicationSyntaxException;
import com.crusnikatelier.rss.pojos.Item;

public class ItemTest {

	@Test
	public void constructorSuccessTest() {
		Item i = new Item();
		assertNotNull(i);
	}
	
	@Test(expected=SyndicationSyntaxException.class)
	public void toElementInvalidTitleFailureTest(){
		Item i = new Item();
		//i.toElement();
	}
	
	@Test
	public void toElementTitleSuccessTest(){
		Item i = new Item();
		i.setTitle("My Title");
		//i.toElement();
		//assertTrue(i.isValid());
	}
	
	@Test
	public void toElementDescriptionSucceessTest(){
		Item i = new Item();
		i.setDescription("My Description");
		//i.toElement();
		//assertTrue(i.isValid());
	}
	
}
