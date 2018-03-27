package com.brecucoder.ordero.domain.item;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class ItemRepository {
    private static int dataBaseIndex = 0;
    private Map<Integer, Item> items;

    public ItemRepository() {
        items = new HashMap<>();
        storeItem(new Item("SomeItem", "someItemDescription", 50.00, 100));
        storeItem(new Item("SomeItem2", "someOtherItemDescription", 99.99, 200));
    }

    public List<Item> getItems() {
        return Collections.unmodifiableList(new ArrayList<>(items.values()));
    }

    public Item getItem(Integer id) {
        return items.get(id);
    }

    public Item storeItem(Item item) {
        item.setId(dataBaseIndex++);
        items.put(item.getId(), item);
        return item;
    }

    public Item updateItem(Item updatedItem) {
        items.put(updatedItem.getId(), updatedItem);
        return updatedItem;
    }

}
