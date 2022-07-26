package advanced.app.v5;

import advanced.trace.callback.TraceTemplate;
import advanced.trace.logtrace.LogTrace;
import advanced.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * 템플릿 콜백 패턴 적용
 */
@Service
public class OrderServiceV5 {

    private final TraceTemplate template;
    private final OrderRepositoryV5 orderRepository;

    public OrderServiceV5(OrderRepositoryV5 orderRepository, LogTrace trace) {
        this.orderRepository = orderRepository;
        this.template = new TraceTemplate(trace);
    }

    public void orderItem(String itemId) {

        /**
         * 반환 타입 없음
         * 익명 내부 클래스를 사용
         * 실행하면서 로그로 남길 message 와 전략을 파라미터로 전달
         * 람다 사용
         */
        template.execute("OrderService.request()", () -> {
            orderRepository.save(itemId);
            return null;
        });
    }
}
