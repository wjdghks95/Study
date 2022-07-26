package advanced.trace.callback;

import advanced.trace.TraceStatus;
import advanced.trace.logtrace.LogTrace;

/**
 * 템플릿 콜백 패턴
 * 변하지 않는 로직을 가지고 있는 템플릿 역할
 * <T> 제네릭을 사용, 반환 타입을 정의
 */
public class TraceTemplate {

    private final LogTrace trace;

    public TraceTemplate(LogTrace trace) {
        this.trace = trace;
    }

    public <T> T execute(String message, TraceCallback<T> callback) {
        TraceStatus status = null;
        try {
            status = trace.begin(message);
            //로직 호출
            T result = callback.call();
            trace.end(status);
            return result;
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }
    }
}
