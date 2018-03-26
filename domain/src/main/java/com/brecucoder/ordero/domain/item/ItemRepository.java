package com.brecucoder.ordero.domain.item;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.*;

@Component
public class ItemRepository {
    private static int dataBaseIndex = 0;
    private Map<Integer, Item> items;

    public ItemRepository() {
        items = new HashMap<>();
        storeItem(new Item("SomeItem", "someItemDescription", BigDecimal.valueOf(50)));
        storeItem(new Item("SomeItem2", "someOtherItemDescription", BigDecimal.valueOf(99)));
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

}
