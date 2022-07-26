package advanced.app.v5;

import advanced.trace.callback.TraceTemplate;
import advanced.trace.logtrace.LogTrace;
import advanced.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 * 템플릿 콜백 패턴 적용
 */
@Repository
public class OrderRepositoryV5 {

    private final TraceTemplate template;

    public OrderRepositoryV5(LogTrace trace) {
        this.template = new TraceTemplate(trace);
    }
    public void save(String itemId) {

        /**
         * 반환 타입 없음
         * 익명 내부 클래스를 사용
         * 실행하면서 로그로 남길 message 와 전략을 파라미터로 전달
         * 람다 사용
         */
        template.execute("OrderRepository.save()", () -> {
            //저장 로직
            if (itemId.equals("ex")) {
                throw new IllegalStateException("예외 발생!");
            }

            sleep(1000);

            return null;
        });
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
