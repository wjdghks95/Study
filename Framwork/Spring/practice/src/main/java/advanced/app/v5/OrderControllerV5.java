package advanced.app.v5;

import advanced.trace.callback.TraceCallback;
import advanced.trace.callback.TraceTemplate;
import advanced.trace.logtrace.LogTrace;
import advanced.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 템플릿 콜백 패턴 적용
 */
@RestController
public class OrderControllerV5 {

    private final TraceTemplate template;
    private final OrderServiceV5 orderService;

    public OrderControllerV5(OrderServiceV5 orderService, LogTrace trace) {
        this.orderService = orderService;
        this.template = new TraceTemplate(trace);
    }

    @GetMapping("/v5/request")
    public String request(String itemId) {

        /**
         * 반환 타입은 String
         * 익명 내부 클래스를 사용
         * 실행하면서 로그로 남길 message 와 전략을 파라미터로 전달
         */
        return template.execute("OrderController.request()", new TraceCallback<>() {
            @Override
            public String call() {
                orderService.orderItem(itemId);
                return "ok";
            }
        });
    }
}
