package advanced.trace.callback;

/**
 * 템플릿 콜백 패턴
 * 콜백을 전달하는 인터페이스
 * <T> 제네릭을 사용, 콜백의 반환 타입을 정의
 */
public interface TraceCallback<T> {
    T call();
}
