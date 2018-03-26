package com.brecucoder.ordero.api.item;

import com.brecucoder.ordero.domain.item.Item;
import org.springframework.stereotype.Component;

import static com.brecucoder.ordero.domain.item.Item.ItemBuilder.item;

@Component
public class ItemMapper {

    public static ItemDto toDto(Item item) {
        ItemDto itemDto = new ItemDto();
        itemDto.setId(item.getId());
        itemDto.setName(item.getName()+"-DTO");
        itemDto.setDescription(item.getDescription());
        itemDto.setPrice(item.getPrice());
        itemDto.setStock(item.getStock());
    return itemDto;
    }

    public static Item toDomain(ItemDto itemDto) {
        return item()
                .withId(itemDto.getId())
                .withName(itemDto.getName())
                .withDescription(itemDto.getDescription())
                .withPrice(itemDto.getPrice())
                .withStock(itemDto.getStock())
                .build();
    }
}
