package com.example.springapplication;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.dao.TransientDataAccessResourceException;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.example.springapplication.UserServiceImpl.MIN_LOGCOUNT_FOR_SILVER;
import static com.example.springapplication.UserServiceImpl.MIN_RECOMMEND_FOR_GOLD;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppContext.class)
@ActiveProfiles("test")
@Rollback(value = false)
public class UserServiceImplTest {

    @Autowired UserService userService;
    @Autowired UserService testUserService;
    @Autowired UserDao userDao;
    @Autowired DataSource dataSource;
    @Autowired PlatformTransactionManager transactionManager;
    @Autowired MailSender mailSender;
    @Autowired ApplicationContext context;

    List<User> users;

    @Before
    public void setUp() {
        users = Arrays.asList(
                new User("user1", "유저1", "1234", Level.BASIC, MIN_LOGCOUNT_FOR_SILVER - 1, 0, "user1@test.com"),
                new User("user2", "유저2", "1234", Level.BASIC, MIN_LOGCOUNT_FOR_SILVER, 0, "user2@test.com"),
                new User("user3", "유저3", "1234", Level.SILVER, 60, MIN_RECOMMEND_FOR_GOLD - 1, "user3@test.com"),
                new User("user4", "유저4", "1234", Level.SILVER, 60, MIN_RECOMMEND_FOR_GOLD, "user4@test.com"),
                new User("user5", "유저5", "1234", Level.GOLD, 100, Integer.MAX_VALUE, "user5@test.com")
        );
    }

    @Test
    public void upgradeLevels() throws Exception {
        UserServiceImpl userServiceImpl = new UserServiceImpl();

        MockUserDao mockUserDao = new MockUserDao(this.users);
        userServiceImpl.setUserDao(mockUserDao);

        MockMailSender mockMailSender = new MockMailSender();
        userServiceImpl.setMailSender(mockMailSender);

        userServiceImpl.upgradeLevels();

        List<User> updated = mockUserDao.getUpdated();
        assertThat(updated.size(), is(2));
        checkUserAndLevel(updated.get(0), "user2", Level.SILVER);
        checkUserAndLevel(updated.get(1), "user4", Level.GOLD);

        List<String> requests = mockMailSender.getRequests();
        assertThat(requests.size(), is(2));
        assertThat(requests.get(0), is(users.get(1).getEmail()));
        assertThat(requests.get(1), is(users.get(3).getEmail()));
    }

    private void checkUserAndLevel(User updated, String expectedId, Level level) {
        assertThat(updated.getId(), is(expectedId));
        assertThat(updated.getLevel(), is(level));
    }

    @Test
    public void add() {
        userDao.deleteAll();

        User userWithLevel = users.get(4);
        User userWithoutLevel = users.get(0);
        userWithoutLevel.setLevel(null);

        userService.add(userWithLevel);
        userService.add(userWithoutLevel);

        User userWithLevelRead = userDao.get(userWithLevel.getId());
        User userWithoutLevelRead = userDao.get(userWithoutLevel.getId());

        assertThat(userWithLevelRead.getLevel(), is(userWithLevel.getLevel()));
        assertThat(userWithoutLevelRead.getLevel(), is(Level.BASIC));
    }

    private void checkLevelUpgraded(User user, boolean upgraded) {
        User userUpdate = userDao.get(user.id);
        if (upgraded) {
            assertThat(userUpdate.getLevel(), is(user.getLevel().nextLevel()));
        } else {
            assertThat(userUpdate.getLevel(), is(user.getLevel()));
        }
    }

//    @Test
    public void upgradeAllOrNothing() throws Exception {
        userDao.deleteAll();
        for (User user : users) {
            userDao.add(user);
        }

        try {
//            txUserService.upgradeLevels();
            this.testUserService.upgradeLevels();
            fail("TestUserServiceException expected");
        } catch (TestUserServiceException e) {

        }

        checkLevelUpgraded(users.get(1), false);
    }

    @Test
    public void mockUpgradeLevels() throws Exception {
        UserServiceImpl userServiceImpl = new UserServiceImpl();

        UserDao mockUserDao = mock(UserDao.class);
        when(mockUserDao.getAll()).thenReturn(this.users);
        userServiceImpl.setUserDao(mockUserDao);

        MailSender mockMailSender = mock(MailSender.class);
        userServiceImpl.setMailSender(mockMailSender);

        userServiceImpl.upgradeLevels();
        verify(mockUserDao, times(2)).update(any(User.class));
        verify(mockUserDao, times(2)).update(any(User.class));
        verify(mockUserDao).update(users.get(1));
        assertThat(users.get(1).getLevel(), is(Level.SILVER));
        verify(mockUserDao).update(users.get(3));
        assertThat(users.get(3).getLevel(), is(Level.GOLD));

        ArgumentCaptor<SimpleMailMessage> mailMessageArg = ArgumentCaptor.forClass(SimpleMailMessage.class);
        verify(mockMailSender, times(2)).send(mailMessageArg.capture());
        List<SimpleMailMessage> mailMessages = mailMessageArg.getAllValues();
        assertThat(mailMessages.get(0).getTo()[0], is(users.get(1).getEmail()));
        assertThat(mailMessages.get(1).getTo()[0], is(users.get(3).getEmail()));
    }

    @Test(expected = TransientDataAccessResourceException.class)
    public void readOnlyTransactionAttribute() {
        testUserService.getAll();
    }

    static class MockMailSender implements MailSender {
        private List<String> requests = new ArrayList<>();

        public List<String> getRequests() {
            return requests;
        }

        @Override
        public void send(SimpleMailMessage simpleMailMessage) throws MailException {
            requests.add(simpleMailMessage.getTo()[0]);

        }

        @Override
        public void send(SimpleMailMessage[] simpleMailMessages) throws MailException {

        }
    }

    static class TestUserService extends UserServiceImpl {
        private String id = "user4";

        @Override
        protected void upgradeLevel(User user) {
            if (user.getId().equals(this.id)) throw new TestUserServiceException();
            super.upgradeLevel(user);
        }

        @Override
        public List<User> getAll() {
            for (User user : super.getAll()) {
                super.update(user);
            }
            return null;
        }
    }

    static class TestUserServiceException extends RuntimeException {}

    static class MockUserDao implements UserDao {

        private List<User> users;
        private List<User> updated = new ArrayList<>();

        public MockUserDao(List<User> users) {
            this.users = users;
        }

        public List<User> getUpdated() {
            return this.updated;
        }

        @Override
        public void add(User user) {
            throw new UnsupportedOperationException();
        }

        @Override
        public User get(String id) {
            throw new UnsupportedOperationException();
        }

        @Override
        public List<User> getAll() {
            return this.users;
        }

        @Override
        public void deleteAll() {
            throw new UnsupportedOperationException();
        }

        @Override
        public int getCount() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void update(User user) {
            updated.add(user);
        }
    }

    @Test
    public void advisorAutoProxyCreator() {
//        assertThat(testUserService, is(java.lang.reflect.Proxy.class));
    }

    @Test
    public void transactionSync() {
        DefaultTransactionDefinition txDefinition = new DefaultTransactionDefinition(); // 트랜잭션 정의는 기본 값을 사용한다.
        txDefinition.setReadOnly(true); // 읽기 전용 트랜잭션으로 정의한다.

        // 트랜잭션 매니저에게 트랜잭션을 요청한다. 기존에 시작된 트랜재션이 없으니 새로운 트랜잭션을 시작시키고 트랜잭션 정보를 돌려준다.
        // 동시에 만들어진 트랜잭션을 다른 곳에서도 사용할 수 있도록 동기화 한다.
        TransactionStatus txStatus = transactionManager.getTransaction(txDefinition);

        // 앞에서 만들어진 트랜잭션에 모두 참여한다.
        userService.deleteAll();

        userService.add(users.get(0));
        userService.add(users.get(1));

        transactionManager.commit(txStatus); // 앞에서 시작한 트랜잭션을 커밋한다.
    }

    @Test
    public void transactionSync2() {
        userDao.deleteAll();
        assertThat(userDao.getCount(), is(0));

        DefaultTransactionDefinition txDefinition = new DefaultTransactionDefinition();
        TransactionStatus txStatus = transactionManager.getTransaction(txDefinition);

        userService.add(users.get(0));
        userService.add(users.get(1));
        assertThat(userDao.getCount(), is(2));

        transactionManager.rollback(txStatus);

        assertThat(userDao.getCount(), is(0));
    }

    @Test
    public void transactionSync3() {
        DefaultTransactionDefinition txDefinition = new DefaultTransactionDefinition();
        TransactionStatus txStatus = transactionManager.getTransaction(txDefinition);

        try {
            userDao.deleteAll();
            userService.add(users.get(0));
            userService.add(users.get(1));
        } finally {
            transactionManager.rollback(txStatus);

        }
    }

    @Test
    @Transactional
    public void transactionSync4() {
        userService.deleteAll();
        userService.add(users.get(0));
        userService.add(users.get(1));
    }

    @Autowired DefaultListableBeanFactory bf;

    @Test
    public void beans() {
        for (String n : bf.getBeanDefinitionNames()) {
            System.out.println(n + " \t" + bf.getBean(n).getClass().getName());
        }
    }
}