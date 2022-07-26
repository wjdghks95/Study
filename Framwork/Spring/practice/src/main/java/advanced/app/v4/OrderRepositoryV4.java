package advanced.app.v4;

import advanced.trace.TraceStatus;
import advanced.trace.logtrace.LogTrace;
import advanced.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 * 템플릿 메서드 패턴 적용
 */
@Repository
@RequiredArgsConstructor
public class OrderRepositoryV4 {

    private final LogTrace trace;
    public void save(String itemId) {

        /**
         * AbstractTemplate 의 반환 타입 없음<Void>, null 반환
         * 익명 내부 클래스를 사용
         * 템플릿을 실행하면서 로그로 남길 message 를 전달
         */
        AbstractTemplate<Void> template = new AbstractTemplate<>(trace) {
            @Override
            protected Void call() {
                //저장 로직
                if (itemId.equals("ex")) {
                    throw new IllegalStateException("예외 발생!");
                }
                sleep(1000);
                return null;
            }
        };

        template.execute("OrderRepository.save()");
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
