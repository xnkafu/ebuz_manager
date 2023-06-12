package com.selacha.start.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.selacha.start.domain.Item;
import com.selacha.start.repository.ItemRepo;
import com.selacha.start.service.ItemService;

@Service
public class ItemServiceImplementation implements ItemService {
	
	@Autowired
	private ItemRepo itemRepo;

	@Override
	public Item saveItem(Item item) {
		Optional<Item> itemTemp =  itemRepo.findByNameAndModel(item.getName(), item.getModel());
		if (itemTemp.isEmpty()) {
			return itemRepo.save(item);
			
		}
		return null;
	}

	@Override
	public boolean deleteItem(long id) {
		Optional<Item> item =  itemRepo.findById(id);
		if (!item.isEmpty()) {
			itemRepo.deleteById(id);
			return true;
			
		}
		return false;
	}

	@Override
	public Item findItem(long id) {
		Optional<Item> item =  itemRepo.findById(id);
		if (!item.isEmpty()) {
			return item.get();
			
		}
		return null;
	}

	@Override
	public List<Item> allItems() {
		return itemRepo.findAll();
	}
	
	public List<Item> allItemsStock() {
		return itemRepo.findAll();
	}


}
