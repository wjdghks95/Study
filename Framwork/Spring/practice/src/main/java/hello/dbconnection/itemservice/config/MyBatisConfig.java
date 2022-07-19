package hello.dbconnection.itemservice.config;

import hello.dbconnection.itemservice.repository.ItemRepository;
import hello.dbconnection.itemservice.repository.mybatis.ItemMapper;
import hello.dbconnection.itemservice.repository.mybatis.MyBatisItemRepository;
import hello.dbconnection.itemservice.service.ItemService;
import hello.dbconnection.itemservice.service.ItemServiceV1;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class MyBatisConfig {

    private final ItemMapper itemMapper;

    @Bean
    public ItemService itemService() {
        return new ItemServiceV1(itemRepository());
    }
    @Bean
    public ItemRepository itemRepository() {
        return new MyBatisItemRepository(itemMapper);
    }
}
