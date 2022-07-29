package aop.proxyvs;

import aop.member.MemberService;
import aop.member.MemberServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.aop.framework.ProxyFactory;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 프록시 타입 캐스팅 문제
 */
@Slf4j
public class ProxyCastingTest {

    /**
     * JDK 동적 프록시
     *  - 인터페이스가 있는 경우
     *  - setProxyTargetClass(false) 인 경우
     *
     *  인터페이스를 기반으로 프록시가 생성되기 때문에 구현 클래스는 전혀 알지 못함
     */
    @Test
    void jdkProxy() {
        MemberServiceImpl target = new MemberServiceImpl();
        ProxyFactory proxyFactory = new ProxyFactory(target);
        proxyFactory.setProxyTargetClass(false); //JDK 동적 프록시

        //프록시를 인터페이스로 캐스팅 성공
        MemberService memberServiceProxy = (MemberService) proxyFactory.getProxy();
        log.info("proxy class={}", memberServiceProxy.getClass());

        //JDK 동적 프록시를 구현 클래스로 캐스팅 시도 실패, ClassCastException 예외 발생
        assertThrows(ClassCastException.class, () -> {
            MemberServiceImpl castingMemberService = (MemberServiceImpl) memberServiceProxy;});
    }

    /**
     * CGLIB 프록시
     *  - 인터페이스가 없는 경우
     *  - setProxyTargetClass(true) 인 경우
     *
     *  구현 클래스를 기반으로 프록시가 생성되기 때문에 구현 클래스와 인터페이스까지 모두 앎앎
    */
    @Test
    void cglibProxy() {
        MemberServiceImpl target = new MemberServiceImpl();
        ProxyFactory proxyFactory = new ProxyFactory(target);
        proxyFactory.setProxyTargetClass(true);//CGLIB 프록시

        //프록시를 인터페이스로 캐스팅 성공
        MemberService memberServiceProxy = (MemberService) proxyFactory.getProxy();
        log.info("proxy class={}", memberServiceProxy.getClass());

        //CGLIB 프록시를 구현 클래스로 캐스팅 시도 성공
        MemberServiceImpl castingMemberService = (MemberServiceImpl) memberServiceProxy;
    }
}