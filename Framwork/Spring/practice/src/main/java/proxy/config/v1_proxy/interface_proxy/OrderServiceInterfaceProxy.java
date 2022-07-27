package proxy.config.v1_proxy.interface_proxy;

import lombok.RequiredArgsConstructor;
import proxy.app.v1.OrderServiceV1;
import proxy.trace.TraceStatus;
import proxy.trace.logtrace.LogTrace;

/**
 * 프록시 패턴 - 인터페이스 기반
 * OrderServiceV1 의 기능에 공통 로직(logTrace)을 추가하고 그 안에서 실제 객체를 호출하도록 구현한 프록시
 */
@RequiredArgsConstructor
public class OrderServiceInterfaceProxy implements OrderServiceV1 {

    private final OrderServiceV1 target;
    private final LogTrace logTrace;

    @Override
    public void orderItem(String itemId) {

        TraceStatus status = null;
        try {
            status = logTrace.begin("OrderService.orderItem()");

            //target 호출
            target.orderItem(itemId);

            logTrace.end(status);
        } catch (Exception e) {
            logTrace.exception(status, e);
            throw e;
        }
    }
}
