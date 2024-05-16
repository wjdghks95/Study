package com.example.springbook2.aopAndLtw.aspectAop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SimpleMonitoringAspect {

    @Pointcut("execution(* hello(..))")
    private void all() {}

//    @Around("all()")
    @Around("execution(* *(..))")
    public Object printParametersAndReturnVal(ProceedingJoinPoint joinPoint) throws Throwable {
        Object ret = joinPoint.proceed();
        return ret;
    }

    @Pointcut("within(com.example.springbook2.aopAndLtw..*)")
    public void layer() {}

    // this는 프록시인 빈 오브젝트의 타입을 지정하는 것이므로 다음 표현식은 HelloImpl 빈을 선택해준다.
    @Pointcut("this(com.example.springbook2.aopAndLtw.aspectAop.Hello)")
    public void layer2() {}

    // 프록시는 HelloImpl 타입이 아니기 때문에 HelloImpl 빈을 선택하지 못한다.
    @Pointcut("this(com.example.springbook2.aopAndLtw.aspectAop.HelloImpl)")
    public void layer3() {}

    // target은 타깃 오브젝트의 타입을 비교하기 때문에 Hello, HelloImpl 두 가지 경우 모두 HelloImpl 빈을 선택할 수 있다.
    @Pointcut("target(com.example.springbook2.aopAndLtw.aspectAop.HelloImpl)")
    public void layer4() {}

    @Pointcut("args()")
    public void layer5() {}
    @Pointcut("args(String)")
    public void layer6() {}
    @Pointcut("args(String, ..)")
    public void layer7() {}
    @Pointcut("args(String, *)")
    public void layer8() {}

    @Pointcut("@target(org.springframework.stereotype.Controller)")
    public void layer9() {}
    @Pointcut("@within(org.springframework.stereotype.Controller)")
    public void layer10() {}

    @Pointcut("@args(org.springframework.web.bind.annotation.RequestParam)")
    public void layer11() {}

    @Pointcut("@annotation(org.springframework.transaction.annotation.Transactional)")
    public void layer12() {}

    @Pointcut("bean(*Service)")
    public void layer13() {}

    @Pointcut("within(com.example.springbook2.aopAndLtw.aspectAop.HelloImpl..*) && args(java.io.Serializable)")
    public void layer14() {}
    @Pointcut("!within(com.example.springbook2.aopAndLtw.aspectAop.HelloImpl..*) || args(java.io.Serializable)")
    public void layer15() {}


    @Pointcut("execution(* *(..))")
    public void myPointcut() {}

    @Around("myPointcut()")
    public Object doNothing(ProceedingJoinPoint joinPoint) throws Throwable {
        Object ret = joinPoint.proceed();
        return ret;
    }

    @Before("myPointcut()")
    public void logJoinPoint(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature().getDeclaringTypeName());
        System.out.println(joinPoint.getSignature().getName());
        for (Object arg : joinPoint.getArgs()) {
            System.out.println(arg);
        }
    }

    @AfterReturning(pointcut = "myPointcut()", returning = "ret")
    public void logReturnValue(Object ret){

    }

    @AfterThrowing(pointcut = "myPointcut()", throwing = "ex")
    public void logDAException(DataAccessException ex) {

    }

    @After("myPointcut()")
    public void logProc() {}

    @Pointcut("@target(bj)")
    private void batchJob(BatchJob bj){}

    @Before("batchJob(bj)")
    public void beforeBatch(BatchJob bj) {}
}
