package com.example.objectAndDI.user;

import com.example.objectAndDI.user.dao.UserDao;
import com.example.objectAndDI.user.domain.User;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.sql.SQLException;

public class UserDaoXmlTest {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
        UserDao dao = context.getBean("userDao", UserDao.class);

        User user = new User();
        user.setId("julee");
        user.setName("이정환");
        user.setPassword("1234");

        dao.add(user);

        System.out.println(user.getId() + " 등록 성공");

        User user2 = dao.get(user.getId());
        System.out.println(user2.getName());
        System.out.println(user2.getPassword());
        System.out.println(user2.getId() + " 조회 성공");
    }
}
