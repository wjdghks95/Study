package advanced.trace.template;

import advanced.trace.TraceStatus;
import advanced.trace.logtrace.LogTrace;

/**
 * 템플릿 메서드 패턴의 부모클래스
 * <T> 제네릭을 사용, 반환 타입 정의
 */
public abstract class AbstractTemplate<T> {

    private final LogTrace trace;

    public AbstractTemplate(LogTrace trace) {
        this.trace = trace;
    }

    public T execute(String message) {
        TraceStatus status = null;

        try {
            status = trace.begin(message);

            //로직 호출
            T result = call();

            trace.end(status);
            return result;
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }
    }

    // 변하는 부분을 처리하는 메서드 -> 상속으로 구현
    protected abstract T call();
}
