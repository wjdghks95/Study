package jpa.service;

import jpa.domain.item.Item;
import jpa.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional(readOnly = true) //읽기 전용 트랜잭션
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    /** 상품 저장 */
    @Transactional //변경 가능 트랜잭션션
   public void saveItem(Item item) {
        itemRepository.save(item);
    }

    /** 상품 전체 조회 */
    public List<Item> findItems() {
        return itemRepository.findAll();
    }

    /** 상품 단일 조회 */
    public Item findOne(Long itemId) {
        return itemRepository.findOne(itemId);
    }

    /**
     * 상품 수정
     * 영속성 컨텍스트가 자동 변경
     */
    @Transactional
    public void updateItem(Long id, String name, int price, int stockQuantity) {
        Item item = itemRepository.findOne(id);
        item.setName(name);
        item.setPrice(price);
        item.setStockQuantity(stockQuantity);
    }
}
