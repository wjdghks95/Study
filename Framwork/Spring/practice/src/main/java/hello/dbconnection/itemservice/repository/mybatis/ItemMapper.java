package hello.dbconnection.itemservice.repository.mybatis;

import hello.dbconnection.itemservice.domain.Item;
import hello.dbconnection.itemservice.repository.ItemSearchCond;
import hello.dbconnection.itemservice.repository.ItemUpdateDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

/**
 * MyBatis 매핑 XML 을 호출해주는 매퍼 인터페이스
 */
@Mapper
public interface ItemMapper {

    void save(Item item);

    void update(@Param("id") Long id, @Param("updateParam") ItemUpdateDto updateParam);

    Optional<Item> findById(Long id);

    List<Item> findAll(ItemSearchCond itemSearch);
}
