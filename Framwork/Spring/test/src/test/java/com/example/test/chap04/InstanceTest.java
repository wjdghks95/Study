package com.example.test.chap04;

import com.example.test.Study;
import com.example.test.chap02.FastTest;
import com.example.test.chap02.SlowTest;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class InstanceTest {

    @BeforeAll // TestInstance -> static X
    void beforeAll() {
        System.out.println("before all");
    }

    @AfterAll // TestInstance -> static X
    void afterAll() {
        System.out.println("after all");
    }

    int value = 1;

    @FastTest
    @DisplayName("스터디 만들기 fast")
    void create_new_study() {
        System.out.println(this);
        System.out.println(value++);
        Study actual = new Study(1);
        assertThat(actual.getLimit()).isGreaterThan(0);
    }

    @SlowTest
    @DisplayName("스터디 만들기 slow")
    void create_new_study_again() {
        System.out.println(this);
        System.out.println("create1 " + value++);
    }
}