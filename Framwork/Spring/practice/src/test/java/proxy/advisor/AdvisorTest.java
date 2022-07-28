package proxy.advisor;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.MethodMatcher;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;
import proxy.common.advice.TimeAdvice;
import proxy.common.service.ServiceImpl;
import proxy.common.service.ServiceInterface;

import java.lang.reflect.Method;

/**
 * Advisor: 단순하게 하나의 Pointcut 과 하나의 Advice 를 가지고 있는 것
 * Pointcut: 어디에 부가 기능을 적용할지, 어디에 부가 기능을 적용하지 않을지 판단하는 필터링 로직
 * Advice: 프록시가 호출하는 부가 기능
 */
@Slf4j
public class AdvisorTest {

    @Test
    void advisorTest1() {
        ServiceImpl target = new ServiceImpl();
        ProxyFactory proxyFactory = new ProxyFactory(target);
        DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor(
                Pointcut.TRUE, new TimeAdvice()); // 항상 true 를 반환하는 포인트 컷과 TimeAdvice 를 가진 Advisor == .addAdvice(new TimeAdvice())
        proxyFactory.addAdvisor(advisor); // 프록시 팩토리에 적용할 어드바이저를 지정
        ServiceInterface proxy = (ServiceInterface) proxyFactory.getProxy();

        proxy.save();
        proxy.find();
    }

    @Test
    @DisplayName("직접 만든 포인트컷")
    void advisorTest2() {
        ServiceImpl target = new ServiceImpl();
        ProxyFactory proxyFactory = new ProxyFactory(target);
        DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor(
                new MyPointcut(), new TimeAdvice()); // MyPointcut 과 TimeAdvice 를 가진 Advisor
        proxyFactory.addAdvisor(advisor); // 프록시 팩토리에 적용할 어드바이저를 지정
        ServiceInterface proxy = (ServiceInterface) proxyFactory.getProxy();

        proxy.save();
        proxy.find();
    }

    static class MyPointcut implements Pointcut {

        @Override
        public ClassFilter getClassFilter() {
            return ClassFilter.TRUE; // 클래스 필터는 항상 true 를 반환
        }

        @Override
        public MethodMatcher getMethodMatcher() {
            return new MyMethodMatcher();
        }
    }

    static class MyMethodMatcher implements MethodMatcher {

        private String matchName = "save";

        @Override
        public boolean matches(Method method, Class<?> targetClass) {

            boolean result = method.getName().equals(matchName); // 메서드 이름이 "save" 인 경우에 true 를 반환

            log.info("포인트컷 호출 method={} targetClass={}", method.getName(), targetClass);
            log.info("포인트컷 결과 result={}", result);

            return result;
        }

        @Override
        public boolean isRuntime() {
            return false;
        }

        @Override
        public boolean matches(Method method, Class<?> targetClass, Object... args) {
            throw new UnsupportedOperationException();
        }
    }

    /**
     * 스프링이 제공하는 포인트컷
     * - NameMatchMethodPointcut: 메서드 이름을 기반으로 매칭, 내부에서는 PatternMatchUtils 를 사용
     * - JdkRegexpMethodPointcut : JDK 정규 표현식을 기반으로 포인트컷을 매칭
     * - TruePointcut: 항상 참을 반환
     * - AnnotationMatchingPointcut: 애노테이션으로 매칭
     * - AspectJExpressionPointcut: aspectJ 표현식으로 매칭, 가장 많이 사용
     */
    @Test
    @DisplayName("스프링이 제공하는 포인트컷")
    void advisorTest3() {
        ServiceImpl target = new ServiceImpl();
        ProxyFactory proxyFactory = new ProxyFactory(target);
        NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut(); // 메서드 이름 기반 매칭 포인트컷
        pointcut.setMappedNames("save"); // 포인트컷 매칭 이름 설정
        DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor(pointcut, new TimeAdvice());
        proxyFactory.addAdvisor(advisor);
        ServiceInterface proxy = (ServiceInterface) proxyFactory.getProxy();

        proxy.save();
        proxy.find();
    }
}
