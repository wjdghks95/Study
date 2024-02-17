package com.example.objectAndDI.user;

import com.example.objectAndDI.user.dao.DaoFactory;
import com.example.objectAndDI.user.dao.UserDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
        UserDao dao1 = context.getBean("userDao", UserDao.class);
        UserDao dao2 = context.getBean("userDao", UserDao.class);

        System.out.println("dao1 = " + dao1);
        System.out.println("dao2 = " + dao2);
    }
}
