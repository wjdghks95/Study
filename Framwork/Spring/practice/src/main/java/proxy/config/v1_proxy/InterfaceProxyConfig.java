package proxy.config.v1_proxy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import proxy.app.v1.*;
import proxy.config.v1_proxy.interface_proxy.OrderControllerInterfaceProxy;
import proxy.config.v1_proxy.interface_proxy.OrderRepositoryInterfaceProxy;
import proxy.config.v1_proxy.interface_proxy.OrderServiceInterfaceProxy;
import proxy.trace.logtrace.LogTrace;

/**
 * 프록시 패턴 - 인터페이스 기반
 * 스프링 컨테이너에 프록시 객체를 빈으로 등록
 * 프록시 객체는 실제 객체를 참조
 * 실제 객체는 프록시 객체를 통해서 참조될 뿐 스프링 컨테이너에서 관리하지 않음
 * 실제 객체는 다시 프록시 객체를 참조하여 프록시 객체를 실행
 */
@Configuration
public class InterfaceProxyConfig {
    @Bean
    public OrderControllerV1 orderController(LogTrace logTrace) {
        OrderControllerV1Impl controllerImpl = new OrderControllerV1Impl(orderService(logTrace));
        return new OrderControllerInterfaceProxy(controllerImpl, logTrace);
    }

    @Bean
    public OrderServiceV1 orderService(LogTrace logTrace) {
        OrderServiceV1Impl serviceImpl = new OrderServiceV1Impl(orderRepository(logTrace));
        return new OrderServiceInterfaceProxy(serviceImpl, logTrace);
    }

    @Bean
    public OrderRepositoryV1 orderRepository(LogTrace logTrace) {
        OrderRepositoryV1Impl repositoryImpl = new OrderRepositoryV1Impl();
        return new OrderRepositoryInterfaceProxy(repositoryImpl, logTrace);
    }
}
