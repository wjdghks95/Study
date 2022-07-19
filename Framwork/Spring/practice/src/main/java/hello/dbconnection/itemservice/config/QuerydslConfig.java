package hello.dbconnection.itemservice.config;

import hello.dbconnection.itemservice.repository.ItemRepository;
import hello.dbconnection.itemservice.repository.jpa.JpaItemRepositoryV3;
import hello.dbconnection.itemservice.service.ItemService;
import hello.dbconnection.itemservice.service.ItemServiceV1;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
@RequiredArgsConstructor
public class QuerydslConfig {

    private final EntityManager em;

    @Bean
    public ItemService itemService() {
        return new ItemServiceV1(itemRepository());
    }
    @Bean
    public ItemRepository itemRepository() {
        return new JpaItemRepositoryV3(em);
    }
}
