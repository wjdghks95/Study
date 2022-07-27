package proxy.config.v1_proxy.interface_proxy;

import lombok.RequiredArgsConstructor;
import proxy.app.v1.OrderControllerV1;
import proxy.trace.TraceStatus;
import proxy.trace.logtrace.LogTrace;

/**
 * 프록시 패턴 - 인터페이스 기반
 * OrderControllerV1 의 기능에 공통 로직(logTrace)을 추가하고 그 안에서 실제 객체를 호출하도록 구현한 프록시
 */
@RequiredArgsConstructor
public class OrderControllerInterfaceProxy implements OrderControllerV1 {

    private final OrderControllerV1 target;
    private final LogTrace logTrace;

    @Override
    public String request(String itemId) {

        TraceStatus status = null;

        try {
            status = logTrace.begin("OrderController.request()");

            //target 호출
            String result = target.request(itemId);

            logTrace.end(status);
            return result;
        } catch (Exception e) {
            logTrace.exception(status, e);
            throw e;
        }
    }

    @Override
    public String noLog() {
        return target.noLog();
    }
}
