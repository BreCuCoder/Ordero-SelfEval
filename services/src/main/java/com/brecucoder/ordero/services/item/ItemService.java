package com.brecucoder.ordero.services.item;

import com.brecucoder.ordero.domain.item.Item;
import com.brecucoder.ordero.domain.item.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ItemService {

    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }
    public List<Item> getItems() {
        return itemRepository.getItems();
    }

    public Item getItem(Integer id) {
        assertItemIsPresent(itemRepository.getItem(id));
        return itemRepository.getItem(id);
    }

    private void assertItemIsPresent(Item queriedItemById) {
        if (queriedItemById == null) {
            throw new IllegalArgumentException("Not found!") ;
        }
    }


}
