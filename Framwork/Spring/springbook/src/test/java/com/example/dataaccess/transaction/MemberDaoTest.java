package com.example.dataaccess.transaction;

import com.example.dataaccess.Member;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/dataAccessApplicationContext.xml")
public class MemberDaoTest {

    @Autowired MemberJdbcDao memberJdbcDao;
    @Autowired MemberJpaDao memberJpaDao;


    @Test
    public void test() {
        memberJdbcDao.add(new Member(1, "Spring", 1.2));
        memberJpaDao.add(new Member(2, "Jpa", 1.2));

        long count = memberJdbcDao.count();
        assertThat(count, is(2));
    }
}