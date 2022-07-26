package advanced.app.v2;

import advanced.trace.TraceId;
import advanced.trace.TraceStatus;
import advanced.trace.hellotrace.HelloTraceV2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * helloTrace 적용
 * traceId 를 파라미터로 넘김
 */
@Service
@RequiredArgsConstructor
public class OrderServiceV2 {

    private final HelloTraceV2 trace;
    private final OrderRepositoryV2 orderRepository;

    public void orderItem(TraceId traceId, String itemId) {
        TraceStatus status = null;
        try {
            status = trace.beginSync(traceId, "OrderService.orderItem()");
            orderRepository.save(status.getTraceId(), itemId);
            trace.end(status);
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }
    }
}
