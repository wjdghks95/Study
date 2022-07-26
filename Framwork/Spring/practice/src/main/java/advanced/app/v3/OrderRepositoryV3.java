package advanced.app.v3;

import advanced.trace.TraceStatus;
import advanced.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 * logTrace 적용
 * 필드 동기화
 * 동시성 문제 -> ThreadLocal 을 사용한 ThreadLocalLogTrace 적용
 */
@Repository
@RequiredArgsConstructor
public class OrderRepositoryV3 {

    private final LogTrace trace;
    public void save(String itemId) {
        TraceStatus status = null;
        try {
            status = trace.begin("OrderRepository.save()");

            //저장 로직
            if (itemId.equals("ex")) {
                throw new IllegalStateException("예외 발생!");
            }
            sleep(1000);

            trace.end(status);
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
