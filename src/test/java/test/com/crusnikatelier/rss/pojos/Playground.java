package test.com.crusnikatelier.rss.pojos;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.crusnikatelier.rss.Channel;
import com.crusnikatelier.rss.Item;
import com.crusnikatelier.rss.RSS;

public class Playground {

	@Test
	public void Test() throws Exception{
		List<Item> itemList = new ArrayList<Item>(1);
		Item i = null;
		
		i = new Item();
		i.setTitle("My Title");
		i.setDescription("My Description");
		i.setLink("http://www.google.com");
		itemList.add(i);
		
		i = new Item();
		i.setTitle("My Title");
		i.setDescription("My Description");
		i.setLink("http://www.google.com");
		itemList.add(i);
		
		Channel chan = new Channel();
		chan.setTitle("My Title");
		chan.setLink("http://www.google.com");
		chan.setDescription("My Description");
		chan.setItems(itemList);
		
		RSS rss = new RSS();
		rss.setChannel(chan);
		
		
		System.out.println(rss.toString());
		RSS.validate(rss);
	}
}
