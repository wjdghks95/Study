package com.example.bookmanager.domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void test() {
        User user = new User();
        user.setEmail("steve@gmail.com");
        user.setName("steve");
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());

        User user1 = new User("steve", "steve@gmail.com", LocalDateTime.now(), LocalDateTime.now());
        User user2 = new User("martin", "martin@gmail.com");

        User user3 = User.builder().name("martin").email("martin@gmail.com").build();

        System.out.println(">>> " + user);
        System.out.println(">>> " + user1);
        System.out.println(">>> " + user2);
        System.out.println(">>> " + user3);
    }
}