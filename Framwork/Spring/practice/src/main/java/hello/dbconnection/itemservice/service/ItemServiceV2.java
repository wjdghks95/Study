package hello.dbconnection.itemservice.service;

import hello.dbconnection.itemservice.domain.Item;
import hello.dbconnection.itemservice.repository.ItemSearchCond;
import hello.dbconnection.itemservice.repository.ItemUpdateDto;
import hello.dbconnection.itemservice.repository.v2.ItemQueryRepositoryV2;
import hello.dbconnection.itemservice.repository.v2.ItemRepositoryV2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * 스프링 데이터 JPA, Querydsl Repository 주입
 * 기본 CRUD = 스프링 데이터 JPA
 * 동적 쿼리 = Querydsl
 *
 * 트레이드 오프 - 구조의 안정성(ItemServiceV1) vs 단순한 구조와 개발의 편리성(ItemServiceV2)
 */
@Service
@RequiredArgsConstructor
@Transactional
public class ItemServiceV2 implements ItemService{

    private final ItemRepositoryV2 itemRepositoryV2;
    private final ItemQueryRepositoryV2 itemQueryRepositoryV2;

    @Override
    public Item save(Item item) {
        return itemRepositoryV2.save(item);
    }

    @Override
    public void update(Long itemId, ItemUpdateDto updateParam) {
        Item findItem = findById(itemId).orElseThrow();
        findItem.setItemName(updateParam.getItemName());
        findItem.setPrice(updateParam.getPrice());
        findItem.setQuantity(updateParam.getQuantity());
    }

    @Override
    public Optional<Item> findById(Long id) {
        return itemRepositoryV2.findById(id);
    }

    @Override
    public List<Item> findItems(ItemSearchCond cond) {
        return itemQueryRepositoryV2.findAll(cond);
    }
}
