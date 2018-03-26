package com.brecucoder.ordero.api.item;

import com.brecucoder.ordero.domain.item.Item;
import com.brecucoder.ordero.services.item.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
        return itemService.getItems().stream()
                .map(ItemMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping(path = "/{id}", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ItemDto getItem(@PathVariable("id") Integer id) {
        return itemMapper
                .toDto(itemService.getItem(id));
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE,  produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ItemDto createItem(@RequestBody ItemDto item) {
        return itemMapper
                .toDto(itemService
                        .createItem(itemMapper.toDomain(item)));
    }


}
