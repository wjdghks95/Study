package hello.dbconnection.itemservice.repository.v2;

import hello.dbconnection.itemservice.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 스프링 데이터 JPA Repository
 */
public interface ItemRepositoryV2 extends JpaRepository<Item, Long> {
}
