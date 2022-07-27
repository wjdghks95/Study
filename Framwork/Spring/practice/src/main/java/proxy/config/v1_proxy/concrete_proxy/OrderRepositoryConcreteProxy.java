package proxy.config.v1_proxy.concrete_proxy;

import proxy.app.v2.OrderRepositoryV2;
import proxy.trace.TraceStatus;
import proxy.trace.logtrace.LogTrace;

/**
 * 프록시 패턴 - 구체 클래스 기반
 * OrderRepositoryV2 의 기능에 공통 로직(logTrace)을 추가하고 그 안에서 실제 객체를 호출하도록 재정의하는 프록시
 */
public class OrderRepositoryConcreteProxy extends OrderRepositoryV2 {

    private final OrderRepositoryV2 target;
    private final LogTrace logTrace;

    public OrderRepositoryConcreteProxy(OrderRepositoryV2 target, LogTrace logTrace) {
        this.target = target;
        this.logTrace = logTrace;
    }

    @Override
    public void save(String itemId) {

        TraceStatus status = null;

        try {
            status = logTrace.begin("OrderRepository.save()");

            //target 호출
            target.save(itemId);

            logTrace.end(status);
        } catch (Exception e) {
            logTrace.exception(status, e);
            throw e;
        }
    }
}
