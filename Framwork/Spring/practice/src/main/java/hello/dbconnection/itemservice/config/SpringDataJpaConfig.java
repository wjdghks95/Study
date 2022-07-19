package hello.dbconnection.itemservice.config;

import hello.dbconnection.itemservice.repository.ItemRepository;
import hello.dbconnection.itemservice.repository.jpa.JpaItemRepositoryV2;
import hello.dbconnection.itemservice.repository.jpa.SpringDataJpaItemRepository;
import hello.dbconnection.itemservice.service.ItemService;
import hello.dbconnection.itemservice.service.ItemServiceV1;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class SpringDataJpaConfig {

    private final SpringDataJpaItemRepository springDataJpaItemRepository;

    @Bean
    public ItemService itemService() {
        return new ItemServiceV1(itemRepository());
    }
    @Bean
    public ItemRepository itemRepository() {
        return new JpaItemRepositoryV2(springDataJpaItemRepository);
    }
}
