package pagination.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import pagination.dao.ItemDao;
import pagination.model.Item;

public class ItemDaoImpl implements ItemDao {
	static int callCount =0;
	private final Log logger = LogFactory.getLog(getClass());
	private List<Item> items;

	/*
	 * (non-Javadoc)
	 * 
	 * @see pagination.dao.ItemDao#getAllItems()
	 */
	public List<Item> getAllItems() throws Exception {
		logger.info("called getAllItems " + (++callCount) + " times");
		List<Item> numberList = new ArrayList<Item>();
		Item item = null;
		for(int i=0; i<500; i++) {
			item = new Item(String.valueOf(i), Math.random());
			numberList.add(item);
		}
		
		// delay it for cache testing purpose
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return numberList;
	}

	/**
	 * @return the items
	 */
	public List<Item> getItems() {
		return items;
	}

	/**
	 * @param items
	 *          the items to set
	 */
	public void setItems(List<Item> items) {
		this.items = items;
	}

}
