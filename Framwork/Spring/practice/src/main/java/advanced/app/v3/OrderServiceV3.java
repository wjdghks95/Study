package advanced.app.v3;

import advanced.trace.TraceId;
import advanced.trace.TraceStatus;
import advanced.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * logTrace 적용
 * 필드 동기화
 * 동시성 문제 -> ThreadLocal 을 사용한 ThreadLocalLogTrace 적용
 */
@Service
@RequiredArgsConstructor
public class OrderServiceV3 {

    private final LogTrace trace;
    private final OrderRepositoryV3 orderRepository;

    public void orderItem(String itemId) {
        TraceStatus status = null;
        try {
            status = trace.begin("OrderService.orderItem()");
            orderRepository.save(itemId);
            trace.end(status);
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }
    }
}
