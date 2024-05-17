package com.example.springbook2.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.AfterTransaction;
import org.springframework.test.context.transaction.BeforeTransaction;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/test-applicationContext.xml")
@Transactional
public class TransactionTest {

    @Autowired JapDao japDao;

    @Autowired
    PlatformTransactionManager transactionManager;

    @Test
    public void query() {
        List<User> users = japDao.findUser(); // 트랜잭션이 없으므로 오류
    }

    @Test
    public void txTest() {
        new TransactionTemplate(transactionManager).execute(
                new TransactionCallback<Object>() {
                    @Override
                    public Object doInTransaction(TransactionStatus transactionStatus) {
                        transactionStatus.setRollbackOnly(); // 예외가 발생하지 않아도 트랜잭션이 끝날 때 트랜잭션이 롤백되도록 설정한다.

                        // execute() 메소드에 의해 시작된 트랜잭션 안에서 모든 DB 작업이 진행된다.
                        // ...

                        return null;
                    }
                }
        );
    }

    @Test
    @Transactional
    @Rollback(value = false)
    public void txTest2() {
        // 강제 롤백이 적용된 트랜잭션 안에서 실행된다.
        // ...
    }

    @BeforeTransaction
    public void setUpBeforeTx() {}

    @Before
    public void setUpInTx() {}

    @Test
    @Transactional
    public void test() {}

    @After
    public void tearDownInTx() {}

    @AfterTransaction
    public void tearDownAfterTx() {}
}
