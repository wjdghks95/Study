package advanced.app.v4;

import advanced.trace.TraceStatus;
import advanced.trace.logtrace.LogTrace;
import advanced.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * 템플릿 메서드 패턴 적용
 */
@Service
@RequiredArgsConstructor
public class OrderServiceV4 {

    private final LogTrace trace;
    private final OrderRepositoryV4 orderRepository;

    public void orderItem(String itemId) {

        /**
         * AbstractTemplate 의 반환 타입 없음<Void>, null 반환
         * 익명 내부 클래스를 사용
         * 템플릿을 실행하면서 로그로 남길 message 를 전달
         */
        AbstractTemplate<Void> template = new AbstractTemplate<>(trace) {
            @Override
            protected Void call() {
                orderRepository.save(itemId);
                return null;
            }
        };

        template.execute("OrderService.orderItem()");
    }
}
