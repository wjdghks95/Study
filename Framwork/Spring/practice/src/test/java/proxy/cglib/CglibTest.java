package proxy.cglib;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.cglib.proxy.Enhancer;
import proxy.cglib.code.TimeMethodInterceptor;
import proxy.common.service.ConcreteService;

/**
 * CGLIB (동적 프록시) -> 인터페이스가 없이 구현체만 있는 경우
 * Enhancer: 프록시 생성
 */
@Slf4j
public class CglibTest {

    @Test
    void cglib() {
        ConcreteService target = new ConcreteService();

        Enhancer enhancer = new Enhancer(); // CGLIB 는 Enhancer 를 사용해서 프록시를 생성
        enhancer.setSuperclass(ConcreteService.class); // CGLIB는 구체 클래스를 상속 받아서 프록시를 생성
        enhancer.setCallback(new TimeMethodInterceptor(target)); // 프록시에 적용할 실행 로직을 할당
        ConcreteService proxy = (ConcreteService)enhancer.create(); // 프록시를 생성

        log.info("targetClass={}", target.getClass());
        log.info("proxyClass={}", proxy.getClass());
        proxy.call();
    }
}
