package com.example.test.chap05;

import com.example.test.Study;
import com.example.test.chap02.FastTest;
import com.example.test.chap02.SlowTest;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class OrderTest {

    @BeforeAll // TestInstance -> static X
    void beforeAll() {
        System.out.println("before all");
    }

    @AfterAll // TestInstance -> static X
    void afterAll() {
        System.out.println("after all");
    }

    int value = 1;

    @Order(2)
    @FastTest
    @DisplayName("스터디 만들기 fast")
    void create_new_study() {
        System.out.println(this);
        System.out.println(value++);
        Study actual = new Study(1);
        assertThat(actual.getLimit()).isGreaterThan(0);
    }

    @Order(1)
    @SlowTest
    @DisplayName("스터디 만들기 slow")
    void create_new_study_again() {
        System.out.println(this);
        System.out.println("create1 " + value++);
    }

    @Order(3)
    @SlowTest
    @DisplayName("스터디 만들기")
    void create_study() {
        System.out.println(this);
        System.out.println("create1 " + value++);
    }

}