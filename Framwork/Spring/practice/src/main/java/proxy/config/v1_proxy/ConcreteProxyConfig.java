package proxy.config.v1_proxy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import proxy.app.v2.OrderControllerV2;
import proxy.app.v2.OrderRepositoryV2;
import proxy.app.v2.OrderServiceV2;
import proxy.config.v1_proxy.concrete_proxy.OrderControllerConcreteProxy;
import proxy.config.v1_proxy.concrete_proxy.OrderRepositoryConcreteProxy;
import proxy.config.v1_proxy.concrete_proxy.OrderServiceConcreteProxy;
import proxy.trace.logtrace.LogTrace;

/**
 * 프록시 패턴 - 구체 클래스 기반
 * 스프링 컨테이너에 프록시 객체를 빈으로 등록
 * 프록시 객체는 실제 객체를 참조
 * 실제 객체는 프록시 객체를 통해서 참조될 뿐 스프링 컨테이너에서 관리하지 않음
 * 실제 객체는 다시 프록시 객체를 참조하여 프록시 객체를 실행
 */
@Configuration
public class ConcreteProxyConfig {

    @Bean
    public OrderControllerV2 orderController(LogTrace logTrace) {
        OrderControllerV2 controllerImpl = new OrderControllerV2(orderService(logTrace));
        return new OrderControllerConcreteProxy(controllerImpl, logTrace);
    }

    @Bean
    public OrderServiceV2 orderService(LogTrace logTrace) {
        OrderServiceV2 serviceImpl = new OrderServiceV2(orderRepository(logTrace));
        return new OrderServiceConcreteProxy(serviceImpl, logTrace);
    }

    @Bean
    public OrderRepositoryV2 orderRepository(LogTrace logTrace) {
        OrderRepositoryV2 repositoryImpl = new OrderRepositoryV2();
        return new OrderRepositoryConcreteProxy(repositoryImpl, logTrace);
    }
}
