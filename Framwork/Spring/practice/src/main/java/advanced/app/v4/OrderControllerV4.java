package advanced.app.v4;

import advanced.trace.TraceStatus;
import advanced.trace.logtrace.LogTrace;
import advanced.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 템플릿 메서드 패턴 적용
 */
@RestController
@RequiredArgsConstructor
public class OrderControllerV4 {

    private final LogTrace trace;
    private final OrderServiceV4 orderService;

    @GetMapping("/v4/request")
    public String request(String itemId) {

        /**
         * AbstractTemplate 의 반환 타입은 String
         * 익명 내부 클래스를 사용
         * 템플릿을 실행하면서 로그로 남길 message 를 전달
         */
        AbstractTemplate<String> template = new AbstractTemplate<>(trace) {
            @Override
            protected String call() {
                orderService.orderItem(itemId);
                return "ok";
            }
        };

        return template.execute("OrderController.request()");
    }
}
