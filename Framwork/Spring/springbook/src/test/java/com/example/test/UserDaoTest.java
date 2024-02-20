package com.example.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.SQLException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = "/test-applicationContext.xml") // 테스트를 위한 별도의 DI 설정
//@ContextConfiguration(locations = "/applicationContext.xml")
//@DirtiesContext // 테스트 코드에 의한 DI - 테스트 메소드에서 애플리케이션 컨텍스트의 구성이나 상태를 변경 한다는 것을 테스트 컨텍스트 프레임워크에 알려준다.
public class UserDaoTest {

//    @Autowired
//    private ApplicationContext context;

//    @Autowired
    private UserDao dao;
    private User user1;
    private User user2;
    private User user3;

    @Before
    public void setUp() {
//        System.out.println(this.context);
//        System.out.println(this);

        // 컨테이너 없는 DI 테스트
        dao = new UserDao();
        SingleConnectionDataSource dataSource = new SingleConnectionDataSource("jdbc:mysql://localhost/testdb", "root", "1234", true);
        dao.setDataSource(dataSource);

        // 테스트 코드에 의한 DI
//        this.dao = this.context.getBean("userDao", UserDao.class);
//        SingleConnectionDataSource dataSource = new SingleConnectionDataSource("jdbc:mysql://localhost/testdb", "root", "1234", true);
//        dao.setDataSource(dataSource);

        this.user1 = new User("user1", "유저1", "1234");
        this.user2 = new User("user2", "유저2", "1234");
        this.user3 = new User("user3", "유저3", "1234");
    }

    @Test
    public void addAndGet() throws SQLException, ClassNotFoundException {
        dao.deleteAll();
        assertThat(dao.getCount(), is(0));

        dao.add(user1);
        dao.add(user2);
        assertThat(dao.getCount(), is(2));

        User userget1 = dao.get(user1.getId());

        assertThat(userget1.getName(), is(user1.getName()));
        assertThat(userget1.getPassword(), is(user1.getPassword()));

        User userget2 = dao.get(user2.getId());

        assertThat(userget2.getName(), is(user2.getName()));
        assertThat(userget2.getPassword(), is(user2.getPassword()));
    }
    @Test
    public void count() throws SQLException {
        dao.deleteAll();
        assertThat(dao.getCount(), is(0));

        dao.add(user1);
        assertThat(dao.getCount(), is(1));

        dao.add(user2);
        assertThat(dao.getCount(), is(2));

        dao.add(user3);
        assertThat(dao.getCount(), is(3));
    }

    @Test(expected = EmptyResultDataAccessException.class)
    public void getUserFailure() throws SQLException {
        dao.deleteAll();
        assertThat(dao.getCount(), is(0));

        dao.get("unknown_id");
    }
}
