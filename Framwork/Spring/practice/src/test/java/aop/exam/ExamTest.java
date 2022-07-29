package aop.exam;

import aop.exam.annotation.Retry;
import aop.exam.aop.RetryAspect;
import aop.exam.aop.TraceAspect;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import static org.junit.jupiter.api.Assertions.*;

@Import({TraceAspect.class, RetryAspect.class})
@SpringBootTest
class ExamTest {

    @Autowired ExamService examService;

    @Test
    void test() {
        for (int i = 0; i < 5; i++) {
            examService.request("data" + i);
        }
    }

}