package hello.dbconnection.itemservice.config;

import hello.dbconnection.itemservice.repository.ItemRepository;
import hello.dbconnection.itemservice.repository.memory.MemoryItemRepository;
import hello.dbconnection.itemservice.service.ItemService;
import hello.dbconnection.itemservice.service.ItemServiceV1;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MemoryConfig {

    @Bean
    public ItemService itemService() {
        return new ItemServiceV1(itemRepository());
    }

    @Bean
    public ItemRepository itemRepository() {
        return new MemoryItemRepository();
    }

}
