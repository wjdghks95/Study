package com.example.test.chap01;

import com.example.test.domain.Study;
import com.example.test.StudyStatus;
import org.junit.jupiter.api.*;

import java.time.Duration;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class) // 테스트 이름 전략 설정
class AssertionsTest {

    @Test
    @DisplayName("스터디 만들기") // 테스트 이름 설정
    void create_new_study() {
        Study study = new Study(10);
        assertNotNull(study);
        System.out.println("create");

        // assertEquals = 기대 값, 실제 값, 메시지
        Assertions.assertEquals(StudyStatus.DRAFT, study.getStatus(), "스터디를 처음 만들면 상태값이 DRAFT이어야 한다.");
        assertEquals(StudyStatus.DRAFT, study.getStatus(), new Supplier<String>() {
            @Override
            public String get() {
                return "스터디를 처음 만들면 DRAFT이어야 한다.";
            }
        });
        assertTrue(study.getLimitCount() > 0, "스터디 최대 참석 가능 인원은 0보다 커야 한다.");

        // assertAll
        assertAll(
                () -> assertNotNull(study),
                () -> assertEquals(StudyStatus.DRAFT, study.getStatus(), "스터디를 처음 만들면 상태값이 DRAFT이어야 한다."),
                () -> assertTrue(study.getLimitCount() > 0, "스터디 최대 참석 가능 인원은 0보다 커야 한다.")
        );

        // assertThrows
        assertThrows(IllegalArgumentException.class, () -> {
            new Study(-10);
        });

        assertTimeout(Duration.ofSeconds(100), () -> {
            new Study(10);
            Thread.sleep(300);
        });

        assertTimeoutPreemptively(Duration.ofSeconds(100), () -> {
            new Study(10);
            Thread.sleep(300);
        });
    }

    @Test
    @Disabled // 비활성화
    void create1() {
        System.out.println("create1");
    }

    @BeforeAll // 모든 테스트 전에 호출, static
    static void beforeAll() {
        System.out.println("before all");
    }

    @AfterAll // 모든 테스트 후에 호출, static
    static void afterAll() {
        System.out.println("after all");
    }

    @BeforeEach // 각 테스트마다 테스트 수행 전에 실행
    void beforeEach() {
        System.out.println("Before each");
    }

    @AfterEach // 각 테스트마다 테스트 수행 후에 실행
    void afterEach() {
        System.out.println("After each");
    }
}