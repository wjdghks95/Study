package proxy.config.v6_aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import proxy.trace.TraceStatus;
import proxy.trace.logtrace.LogTrace;

/**
 * AnnotationAwareAspectJAutoProxyCreator: @Aspect 를 보고  Advisor 로 변환해서 저장
 * @Aspect: 애노테이션 기반 프록시를 적용
 * @Around 의 메서드는 어드바이스(Advice)로 등록, 포인트컷 AspectJ 표현식 사용
 * @Around 의 메서드 -> 어드바이스(Advice)
 */
@Slf4j
@Aspect
public class LogTraceAspect {

    private final LogTrace logTrace;

    public LogTraceAspect(LogTrace logTrace) {
        this.logTrace = logTrace;
    }

    @Around("execution(* proxy.app..*(..)) && !execution(* proxy.app..noLog(..))")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {

        TraceStatus status = null;

    // log.info("target={}", joinPoint.getTarget()); //실제 호출 대상
    // log.info("getArgs={}", joinPoint.getArgs()); //전달인자
    // log.info("getSignature={}", joinPoint.getSignature()); //join point 시그니처

        try {
            String message = joinPoint.getSignature().toShortString();
            status = logTrace.begin(message);

            //로직 호출
            Object result = joinPoint.proceed();

            logTrace.end(status);
            return result;
        } catch (Exception e) {
            logTrace.exception(status, e);
            throw e;
        }
    }
}
