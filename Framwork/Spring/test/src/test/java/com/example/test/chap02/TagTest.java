package com.example.test.chap02;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

class TagTest {

//    @Test
    @FastTest
    @DisplayName("스터디 만들기 fast") // 테스트 이름 설정
    @Tag("fast")
    void create_new_study() {
        System.out.println("create1");
    }

//    @Test
    @SlowTest
    @DisplayName("스터디 만들기 slow")
    @Tag("slow")
    void create1() {
        System.out.println("create2");
    }
}