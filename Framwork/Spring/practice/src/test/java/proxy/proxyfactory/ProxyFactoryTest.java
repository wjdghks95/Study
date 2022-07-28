package proxy.proxyfactory;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.AopUtils;
import proxy.common.advice.TimeAdvice;
import proxy.common.service.ConcreteService;
import proxy.common.service.ServiceImpl;
import proxy.common.service.ServiceInterface;

import static org.assertj.core.api.Assertions.*;

/**
 * ProxyFactory: 프록시 생성
 * 인터페이스 존재 -> JDK 동적 프록시
 * 인터페이스 X -> CGLIB
 */
@Slf4j
public class ProxyFactoryTest {

    @Test
    @DisplayName("인터페이스가 있으면 JDK 동적 프록시 사용")
    void interfaceProxy() {
        ServiceImpl target = new ServiceImpl();
        ProxyFactory proxyFactory = new ProxyFactory(target);
        proxyFactory.addAdvice(new TimeAdvice()); // 프록시 팩토리를 통해서 만든 프록시가 사용할 부가 기능 로직을 설정
        ServiceInterface proxy = (ServiceInterface) proxyFactory.getProxy(); // 프록시 생성

        log.info("targetClass={}", target.getClass());
        log.info("proxyClass={}", proxy.getClass());

        proxy.save();

        assertThat(AopUtils.isAopProxy(proxy)).isTrue();
        assertThat(AopUtils.isJdkDynamicProxy(proxy)).isTrue();
        assertThat(AopUtils.isCglibProxy(proxy)).isFalse();
    }

    @Test
    @DisplayName("구체 클래스만 있으면 CGLIB 사용")
    void concreteProxy() {
        ConcreteService target = new ConcreteService();
        ProxyFactory proxyFactory = new ProxyFactory(target);
        proxyFactory.addAdvice(new TimeAdvice()); // 프록시 팩토리를 통해서 만든 프록시가 사용할 부가 기능 로직을 설정
        ConcreteService proxy = (ConcreteService) proxyFactory.getProxy(); // 프록시 생성

        log.info("targetClass={}", target.getClass());
        log.info("proxyClass={}", proxy.getClass());

        proxy.call();

        assertThat(AopUtils.isAopProxy(proxy)).isTrue();
        assertThat(AopUtils.isJdkDynamicProxy(proxy)).isFalse();
        assertThat(AopUtils.isCglibProxy(proxy)).isTrue();
    }

    @Test
    @DisplayName("ProxyTargetClass 옵션을 사용하면 인터페이스가 있어도 CGLIB를 사용하고, 클래스 기반 프록시 사용")
    void proxyTargetClass() {
        ServiceInterface target = new ServiceImpl();
        ProxyFactory proxyFactory = new ProxyFactory(target);
        proxyFactory.setProxyTargetClass(true); // CGLIB 사용, 스프링 부트가 AOP를 적용할 때 기본으로 설정
        proxyFactory.addAdvice(new TimeAdvice());  // 프록시 팩토리를 통해서 만든 프록시가 사용할 부가 기능 로직을 설정
        ServiceInterface proxy = (ServiceInterface) proxyFactory.getProxy(); // 프록시 생성

        log.info("targetClass={}", target.getClass());
        log.info("proxyClass={}", proxy.getClass());

        proxy.save();

        assertThat(AopUtils.isAopProxy(proxy)).isTrue();
        assertThat(AopUtils.isJdkDynamicProxy(proxy)).isFalse();
        assertThat(AopUtils.isCglibProxy(proxy)).isTrue();
    }
}
