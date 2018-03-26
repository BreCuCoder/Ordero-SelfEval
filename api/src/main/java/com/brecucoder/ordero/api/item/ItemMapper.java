package com.brecucoder.ordero.api.item;

import com.brecucoder.ordero.domain.item.Item;
import org.springframework.stereotype.Component;

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

}
