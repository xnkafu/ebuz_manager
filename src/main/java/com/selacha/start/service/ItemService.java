package com.selacha.start.service;

import java.util.List;
import com.selacha.start.domain.Item;

public interface ItemService {

	public Item saveItem(Item item);
	
	public boolean deleteItem(long id);
	
	public Item findItem(long id);
	
	public List<Item> allItems();
}
