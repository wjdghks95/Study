package com.example.objectAndDI.user.dao;

public class DaoFactory {
    public UserDao userDao() {
        UserDao userDao = new UserDao(connectionMaker());
        return userDao;
    }

    /*
    public AccountDao accountDao() {
        return new AccountDao(connectionMaker());
    }

    public MessageDao accountDao() {
        return new MessageDao(connectionMaker());
    }
    */

    public DConnectionMaker connectionMaker() {
        DConnectionMaker connectionMaker = new DConnectionMaker();
        return connectionMaker;
    }
}
