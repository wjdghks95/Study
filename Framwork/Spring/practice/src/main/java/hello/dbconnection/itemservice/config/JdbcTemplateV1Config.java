package hello.dbconnection.itemservice.config;

import hello.dbconnection.itemservice.repository.ItemRepository;
import hello.dbconnection.itemservice.repository.jdbctemplate.JdbcTemplateItemRepositoryV1;
import hello.dbconnection.itemservice.service.ItemService;
import hello.dbconnection.itemservice.service.ItemServiceV1;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
@Configuration
@RequiredArgsConstructor
public class JdbcTemplateV1Config {

    private final DataSource dataSource;

    @Bean
    public ItemService itemService() {
        return new ItemServiceV1(itemRepository());
    }
    @Bean
    public ItemRepository itemRepository() {
        return new JdbcTemplateItemRepositoryV1(dataSource);
    }
}
