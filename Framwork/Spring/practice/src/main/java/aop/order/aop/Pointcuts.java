package aop.order.aop;

import org.aspectj.lang.annotation.Pointcut;

/**
 * Pointcut 외부 클래스
 */
public class Pointcuts {

    // aop.order 패키지와 하위 패키지
    @Pointcut("execution(* aop.order..*(..))")
    public void allOrder(){}

    // 타입 패턴이 *Service
    @Pointcut("execution(* *..*Service.*(..))")
    public void allService(){}

    // allOrder && allService
    @Pointcut("allOrder() && allService()")
    public void orderAndService(){}
}
