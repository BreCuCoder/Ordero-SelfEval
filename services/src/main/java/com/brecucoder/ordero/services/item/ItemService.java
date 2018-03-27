package com.brecucoder.ordero.services.item;

import com.brecucoder.ordero.domain.item.Item;
import com.brecucoder.ordero.domain.item.ItemRepository;
import com.brecucoder.ordero.services.exceptions.IllegalFieldFoundException;
import com.brecucoder.ordero.services.exceptions.IllegalFieldFoundException.CrudAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.brecucoder.ordero.services.exceptions.IllegalFieldFoundException.CrudAction.CREATE;
import static com.brecucoder.ordero.services.exceptions.IllegalFieldFoundException.CrudAction.UPDATE;

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

    public Item createItem(Item item) {
        assertItemIdIsNotPresent(item, CREATE);
        return itemRepository.storeItem(item);
    }

    public Item updateItem(Integer id, Item updatedItem) {
        assertItemIdIsNotPresent(updatedItem, UPDATE);
        assertItemIsPresent(itemRepository.getItem(id));
        updatedItem.setId(id);
        return itemRepository.updateItem(updatedItem);
    }

    private void assertItemIsPresent(Item queriedItemById) {
        if (queriedItemById == null) {
            throw new IllegalArgumentException("No such item!") ;
        }
    }

    private void assertItemIdIsNotPresent(Item providedItem, CrudAction action) {
        if (providedItem.getId() != null) {
            throw new IllegalFieldFoundException("ID", Item.class.getSimpleName(), action);
        }
    }


}
