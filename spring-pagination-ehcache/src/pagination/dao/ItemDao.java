package pagination.dao;

import java.util.List;

import pagination.model.Item;

public interface ItemDao {

	public List<Item> getAllItems() throws Exception;

}
