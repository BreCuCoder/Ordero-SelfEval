package com.brecucoder.ordero.api.item;

import com.brecucoder.ordero.domain.item.Item;
import com.brecucoder.ordero.services.item.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "/item")
public class ItemController {

    @Autowired
    private ItemService itemService;
    private ItemMapper itemMapper;

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<ItemDto> getItem() {
//        List<ItemDto> itemDtos = new ArrayList<>();
//        itemService.getItems();
//        for(Item item: itemService.getItems()) {
//            itemDtos.add(ItemMapper.toDto(item));
//        }
//        return itemDtos;
        return itemService.getItems().stream()
                .map(ItemMapper::toDto)
                .collect(Collectors.toList());
    }

}
