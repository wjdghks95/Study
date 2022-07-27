package proxy.config.v1_proxy.concrete_proxy;

import proxy.app.v2.OrderServiceV2;
import proxy.trace.TraceStatus;
import proxy.trace.logtrace.LogTrace;

/**
 * 프록시 패턴 - 구체 클래스 기반
 * OrderServiceV2 의 기능에 공통 로직(logTrace)을 추가하고 그 안에서 실제 객체를 호출하도록 재정의하는 프록시
 */
public class OrderServiceConcreteProxy extends OrderServiceV2 {

    private final OrderServiceV2 target;
    private final LogTrace logTrace;

    public OrderServiceConcreteProxy(OrderServiceV2 target, LogTrace logTrace) {
        super(null);
        this.target = target;
        this.logTrace = logTrace;
    }

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
