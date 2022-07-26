package advanced.app.v1;

import advanced.trace.TraceStatus;
import advanced.trace.hellotrace.HelloTraceV1;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * helloTrace 적용
 * level 관련 기능 X, 트랜잭션 ID 다름
 */
@RestController
@RequiredArgsConstructor
public class OrderControllerV1 {

    private final HelloTraceV1 trace;
    private final OrderServiceV1 orderService;

    @GetMapping("/v1/request")
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
