package test.com.crusnikatelier.rss.pojos;

import static org.junit.Assert.*;

import com.crusnikatelier.rss.exceptions.SyndicationSyntaxException;
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
}
