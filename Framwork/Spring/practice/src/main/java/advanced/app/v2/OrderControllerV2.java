package advanced.app.v2;

import advanced.trace.TraceStatus;
import advanced.trace.hellotrace.HelloTraceV2;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * helloTrace 적용
 * traceId 를 파라미터로 넘김
 */
@RestController
@RequiredArgsConstructor
public class OrderControllerV2 {

    private final HelloTraceV2 trace;
    private final OrderServiceV2 orderService;

    @GetMapping("/v2/request")
    public String request(String itemId) {

        TraceStatus status = null;
        try {
            status = trace.begin("OrderController.request()");
            orderService.orderItem(status.getTraceId(), itemId);
            trace.end(status);
            return "ok";
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }
    }
}
