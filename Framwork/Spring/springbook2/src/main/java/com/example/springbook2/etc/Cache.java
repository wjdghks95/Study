package com.example.springbook2.etc;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import java.util.Date;
import java.util.List;

public class Cache {

    @Cacheable("product")
    public Product bestProduct(String productNo) {
        return null;
    }

    @Cacheable("announcement")
    public List<Announcement> announcements() {
        return null;
    }

    @Cacheable(value = "product", key = "#productNo")
    public Product bestProduct(String productNo, User user, Date datetime) {
        return null;
    }

    @Cacheable(value = "product", key = "#condition.productNo")
    public Product bestProduct(SearchCondition condition) {
        return null;
    }

    @Cacheable(value = "user", condition = "#user.type == 'ADMIN'")
    public User findUser(User user) {
        return null;
    }

    @CacheEvict(value = "product")
    public void refreshBestProducts() {
    }

    @CacheEvict(value = "product", key = "#product.productNo")
//    @CacheEvict(value = "product", allEntries = true)
    public void updateProduct(Product product) {

    }
}
