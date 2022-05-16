package com.example.bookmanager.repository;

import com.example.bookmanager.domain.Gender;
import com.example.bookmanager.domain.User;
import org.apache.tomcat.jni.Local;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.contains;
import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.endsWith;

@SpringBootTest
@Sql({"/data.sql"})
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserHistoryRepository userHistoryRepository;

    @Test
//    @Transactional
    void crud() {
        User user1 = new User("jack", "jack@naver.com");

        userRepository.save(user1);

        List<User> users = userRepository.findAll();
        users.forEach(System.out::println);

//        User user = userRepository.getOne(1L);

//        Optional<User> user = userRepository.findById(1L);
//        User user = userRepository.findById(1L).orElse(null);
//        System.out.println(user);

//        userRepository.save(new User("new martin", "newmartin@naver.com"));
//        userRepository.flush();
//        userRepository.findAll().forEach(System.out::println);

//        boolean exists = userRepository.existsById(1L);
//        System.out.println(exists);

//        userRepository.deleteAll();
//        userRepository.deleteAll(userRepository.findAllById(Lists.newArrayList(1L, 3L)));
//        userRepository.deleteInBatch(userRepository.findAllById(Lists.newArrayList(1L, 3L)));
//        userRepository.deleteAllInBatch();
//        userRepository.findAll().forEach(System.out::println);

//        Page<User> users = userRepository.findAll(PageRequest.of(1, 3));
//
//        System.out.println("page : " + users );
//        System.out.println("totalElements : " + users.getTotalElements());
//        System.out.println("totalPages : " + users.getTotalPages());
//        System.out.println("numberOfElements : " + users.getNumberOfElements());
//        System.out.println("sort : " + users.getSort());
//        System.out.println("size : " + users.getSize());
//
//        users.getContent().forEach(System.out::println);

//        ExampleMatcher matcher = ExampleMatcher.matching()
//                .withIgnorePaths("name")
//                .withMatcher("email", endsWith());
//
//        Example<User> example = Example.of(new User("ma", "gmail.com"), matcher);

//        User user = new User();
//        user.setEmail("naver");
//
//        ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("email", contains());
//        Example<User> example = Example.of(user, matcher);
//
//        userRepository.findAll(example).forEach(System.out::println);

//        userRepository.save(new User("david", "david@naver.com"));
//
//        User user = userRepository.findById(1L).orElseThrow(RuntimeException::new);
//        user.setEmail("martin-update@naver.com");
//
//        userRepository.save(user);
    }

    @Test
    void select() {
        System.out.println(userRepository.findByName("dennis"));

        System.out.println("findByEmail : " + userRepository.findByEmail("steve@gmail.com"));
        System.out.println("getByEmail : " + userRepository.getByEmail("steve@gmail.com"));
        System.out.println("readByEmail : " + userRepository.readByEmail("steve@gmail.com"));
        System.out.println("queryByEmail : " + userRepository.queryByEmail("steve@gmail.com"));
        System.out.println("searchByEmail : " + userRepository.searchByEmail("steve@gmail.com"));
        System.out.println("streamByEmail : " + userRepository.streamByEmail("steve@gmail.com"));
        System.out.println("findUserByEmail : " + userRepository.findUserByEmail("steve@gmail.com"));
        System.out.println("findSomethingByEmail : " + userRepository.findSomethingByEmail("steve@gmail.com"));
//        System.out.println("findSomethingByEmail : " + userRepository.findByByName("steve@gmail.com"));

        System.out.println("findTop1ByName : " +userRepository.findTop1ByName("martin"));
        System.out.println("findFirst1ByName : " +userRepository.findFirst1ByName("martin"));
        System.out.println("findLast1ByName : " +userRepository.findLast1ByName("martin"));

        System.out.println("findByEmailAndName : " +userRepository.findByEmailAndName("martin@another.com", "martin"));
        System.out.println("findByEmailOrName : " +userRepository.findByEmailOrName("martin@another.com", "dennis"));

        System.out.println("findByCreatedAtAfter : " +userRepository.findByCreatedAtAfter(LocalDateTime.now().minusDays(1L)));
        System.out.println("findByIdAfter : " +userRepository.findByIdAfter(4L));
        System.out.println("findByCreatedAtGreaterThan : " +userRepository.findByCreatedAtGreaterThan(LocalDateTime.now().minusDays(1L)));
        System.out.println("findByCreatedAtGreaterThanEqual : " +userRepository.findByCreatedAtGreaterThanEqual(LocalDateTime.now().minusDays(1L)));
        System.out.println("findByCreatedAtBetween : " +userRepository.findByCreatedAtBetween(LocalDateTime.now().minusDays(1L), LocalDateTime.now().plusDays(1L)));
        System.out.println("findByIdBetween : " +userRepository.findByIdBetween(1L, 3L));
        System.out.println("findByIdGreaterThanEqualAndIdLessThanEqual : " +userRepository.findByIdGreaterThanEqualAndIdLessThanEqual(1L, 3L));

        System.out.println("findByIdIsNotNull : " + userRepository.findByIdIsNotNull());
//        System.out.println("findByIdIsNotEmpty : " + userRepository.findByAddressIsNotEmpty());

        System.out.println("findByNameIn : " + userRepository.findByNameIn(Lists.newArrayList("martin", "dennis")));

        System.out.println("findByNameStartingWith : " + userRepository.findByNameStartingWith("mar"));
        System.out.println("findByNameEndingWith : " + userRepository.findByNameEndingWith("tin"));
        System.out.println("findByNameContains : " + userRepository.findByNameContains("art"));
        System.out.println("findByNameLike : " + userRepository.findByNameLike("%art%"));

    }

    @Test
    void pagingAndSortingTest() {
        System.out.println("findTop1ByName : " +userRepository.findTop1ByName("martin"));
        System.out.println("findTopByNameOrderByIdDesc : " +userRepository.findTopByNameOrderByIdDesc("martin"));
        System.out.println("findFirstByNameOrderByIdDescEmailAsc : " +userRepository.findFirstByNameOrderByIdDescEmailAsc("martin"));
        System.out.println("findFirstByNameWithSortParams : " + userRepository.findFirstByName("martin", Sort.by(Sort.Order.desc("id"), Sort.Order.asc("email"))));
        System.out.println("findByNameWithPaging : " + userRepository.findByName("martin", PageRequest.of(0, 1, Sort.by(Sort.Order.desc("id")))).getContent());
    }

    @Test
    void insertAndUpdateTest() {
        User user = new User();
        user.setName("martin");
        user.setEmail("martin@gmail.com");

        userRepository.save(user);

        User user2 = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        user2.setName("marrrrrrtin");

        userRepository.save(user2);
    }

    @Test
    void enumTest() {
        User user = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        user.setGender(Gender.MALE);

        userRepository.save(user);

        userRepository.findAll().forEach(System.out::println);

        System.out.println(userRepository.findRowRecord().get("gender"));
    }

    @Test
    void listener() {
        User user = new User();
        user.setEmail("martin2@gmail.com");
        user.setName("martin");

        userRepository.save(user);

        User user2 = userRepository.findById(1L).orElseThrow(RuntimeException::new);

        userRepository.save(user2);

        userRepository.deleteById(4L);
    }

    @Test
    void prePersistTest() {
        User user = new User();
        user.setEmail("martin2@naver.com");
        user.setName("martin");
//        user.setCreatedAt(LocalDateTime.now());
//        user.setUpdatedAt(LocalDateTime.now());

        userRepository.save(user);

        System.out.println(userRepository.findByEmail("martin2@naver.com"));
    }

    @Test
    void preUpdateTest() {
        User user = userRepository.findById(1L).orElseThrow(RuntimeException::new);

        System.out.println("as-is : " + user);
        userRepository.save(user);

        System.out.println("to-be : " + userRepository.findAll().get(0));
    }

    @Test
    void userHistoryTest() {
        User user = new User();
        user.setEmail("martin-new@naver.com");
        user.setName("martin-new");

        userRepository.save(user);

        user.setName("martin-new-new");

        userRepository.save(user);

        userHistoryRepository.findAll().forEach(System.out::println);
    }
}