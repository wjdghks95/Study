package advanced.app.v3;

import advanced.trace.TraceStatus;
import advanced.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * logTrace 적용
 * 필드 동기화
 * 동시성 문제 -> ThreadLocal 을 사용한 ThreadLocalLogTrace 적용
 */
@RestController
@RequiredArgsConstructor
public class OrderControllerV3 {

    private final LogTrace trace;
    private final OrderServiceV3 orderService;

    @GetMapping("/v3/request")
    public String request(String itemId) {

        TraceStatus status = null;
        try {
            status = trace.begin("OrderController.request()");
            orderService.orderItem(itemId);
            trace.end(status);
            return "ok";
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }
    }
}
