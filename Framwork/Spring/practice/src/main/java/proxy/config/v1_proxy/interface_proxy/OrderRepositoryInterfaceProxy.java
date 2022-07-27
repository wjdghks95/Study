package proxy.config.v1_proxy.interface_proxy;

import lombok.RequiredArgsConstructor;
import proxy.app.v1.OrderRepositoryV1;
import proxy.trace.TraceStatus;
import proxy.trace.logtrace.LogTrace;

/**
 * 프록시 패턴 - 인터페이스 기반
 * OrderRepositoryV1 의 기능에 공통 로직(logTrace)을 추가하고 그 안에서 실제 객체를 호출하도록 구현한 프록시
 */
@RequiredArgsConstructor
public class OrderRepositoryInterfaceProxy implements OrderRepositoryV1 {

    private final OrderRepositoryV1 target;
    private final LogTrace logTrace;

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
