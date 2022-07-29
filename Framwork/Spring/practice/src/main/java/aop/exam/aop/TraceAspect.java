package aop.exam.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * 로그 출력 Aspect
 */
@Slf4j
@Aspect
public class TraceAspect {

    @Before("@annotation(aop.exam.annotation.Trace)") // @Trace 애노테이션 기반
    public void doTrace(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        log.info("[trace] {} args={}", joinPoint.getSignature(), args);
    }
}
