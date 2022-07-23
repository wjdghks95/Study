package jpa.repository;

import jpa.domain.item.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ItemRepository {

    //EntityManager 주입
    private final EntityManager em;

    public void save(Item item) {
        if (item.getId() == null) {
            em.persist(item); //신규 저장
        } else {
            em.merge(item); //수정
        }
    }

    public Item findOne(Long id) {
        return em.find(Item.class, id);
    }

    public List<Item> findAll() {
        return em.createQuery("select i from Item i", Item.class)
                .getResultList();
    }
}