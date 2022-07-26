package advanced.app.v1;

import advanced.trace.TraceStatus;
import advanced.trace.hellotrace.HelloTraceV1;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * helloTrace 적용
 * level 관련 기능 X, 트랜잭션 ID 다름
 */
@Service
@RequiredArgsConstructor
public class OrderServiceV1 {

    private final HelloTraceV1 trace;
    private final OrderRepositoryV1 orderRepository;

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
