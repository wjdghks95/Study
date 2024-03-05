package com.example.serviceabstraction;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.List;

import static com.example.serviceabstraction.UserService.MIN_LOGCOUNT_FOR_SILVER;
import static com.example.serviceabstraction.UserService.MIN_RECOMMEND_FOR_GOLD;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/test-applicationContext.xml")
public class UserServiceTest {

    @Autowired UserService userService;
    @Autowired UserDao userDao;
    @Autowired DataSource dataSource;
    @Autowired PlatformTransactionManager transactionManager;

    List<User> users;

    @Before
    public void setUp() {
        users = Arrays.asList(
                new User("user1", "유저1", "1234", Level.BASIC, MIN_LOGCOUNT_FOR_SILVER - 1, 0),
                new User("user2", "유저2", "1234", Level.BASIC, MIN_LOGCOUNT_FOR_SILVER, 0),
                new User("user3", "유저3", "1234", Level.SILVER, 60, MIN_RECOMMEND_FOR_GOLD - 1),
                new User("user4", "유저4", "1234", Level.SILVER, 60, MIN_RECOMMEND_FOR_GOLD),
                new User("user5", "유저5", "1234", Level.GOLD, 100, Integer.MAX_VALUE)
        );
    }

    @Test
    public void upgradeLevels() throws Exception {
        userDao.deleteAll();
        for (User user : users) {
            userDao.add(user);
        }

        userService.upgradeLevels();

//        checkLevel(users.get(0), Level.BASIC);
//        checkLevel(users.get(1), Level.SILVER);
//        checkLevel(users.get(2), Level.SILVER);
//        checkLevel(users.get(3), Level.GOLD);
//        checkLevel(users.get(4), Level.GOLD);

        checkLevelUpgraded(users.get(0), false);
        checkLevelUpgraded(users.get(1), true);
        checkLevelUpgraded(users.get(2), false);
        checkLevelUpgraded(users.get(3), true);
        checkLevelUpgraded(users.get(4), false);
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

    /*
    private void checkLevel(User user, Level expectedLevel) {
        User userUpdate = userDao.get(user.id);
        assertThat(userUpdate.getLevel(), is(expectedLevel));
    }
     */

    private void checkLevelUpgraded(User user, boolean upgraded) {
        User userUpdate = userDao.get(user.id);
        if (upgraded) {
            assertThat(userUpdate.getLevel(), is(user.getLevel().nextLevel()));
        } else {
            assertThat(userUpdate.getLevel(), is(user.getLevel()));
        }
    }

    @Test
    public void upgradeAllOrNothing() throws Exception {
        UserService.TestUserService testUserService = new UserService.TestUserService(users.get(3).getId());
        testUserService.setUserDao(this.userDao);
//        testUserService.setDataSource(this.dataSource);
        testUserService.setTransactionManager(transactionManager);

        userDao.deleteAll();
        for (User user : users) {
            userDao.add(user);
        }

        try {
            testUserService.upgradeLevels();
            fail("TestUserServiceException expected");
        } catch (UserService.TestUserServiceException e) {

        }

        checkLevelUpgraded(users.get(1), false);
    }
}