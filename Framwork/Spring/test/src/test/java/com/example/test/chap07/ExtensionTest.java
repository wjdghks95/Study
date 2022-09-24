package com.example.test.chap07;

import com.example.test.domain.Study;
import com.example.test.chap02.FastTest;
import com.example.test.chap02.SlowTest;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.RegisterExtension;

import static org.assertj.core.api.Assertions.assertThat;

//@ExtendWith(FindSlowTestExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ExtensionTest {
    int value = 1;

    @RegisterExtension
    static FindSlowTestExtension findSlowTestExtension = new FindSlowTestExtension(1000L);

    @Order(2)
    @FastTest
//    @DisplayName("스터디 만들기 fast")
    void create_new_study() {
        System.out.println(this);
        System.out.println(value++);
        Study actual = new Study(1);
        assertThat(actual.getLimitCount()).isGreaterThan(0);
    }

    @Order(1)
    @Test
    @DisplayName("스터디 만들기 slow")
    void create_new_study_again() throws InterruptedException {
        Thread.sleep(1005L);
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