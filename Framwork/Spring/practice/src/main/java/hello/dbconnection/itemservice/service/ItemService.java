package hello.dbconnection.itemservice.service;

import hello.dbconnection.itemservice.domain.Item;
import hello.dbconnection.itemservice.repository.ItemSearchCond;
import hello.dbconnection.itemservice.repository.ItemUpdateDto;

import java.util.List;
import java.util.Optional;

public interface ItemService {

    Item save(Item item);

    void update(Long itemId, ItemUpdateDto updateParam);

    Optional<Item> findById(Long id);

    List<Item> findItems(ItemSearchCond itemSearch);
}
