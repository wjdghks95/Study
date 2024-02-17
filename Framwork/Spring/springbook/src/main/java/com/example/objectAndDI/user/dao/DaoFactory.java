package com.example.objectAndDI.user.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DaoFactory {

    @Bean
    public UserDao userDao() {
        UserDao userDao = new UserDao(connectionMaker());
        return userDao;
    }

    @Bean
    public DConnectionMaker connectionMaker() {
        DConnectionMaker connectionMaker = new DConnectionMaker();
        return connectionMaker;
    }
}
