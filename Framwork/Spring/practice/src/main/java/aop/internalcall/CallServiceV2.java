package aop.internalcall;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Component;

/**
 * 프록시 내부 호출 문제 -> ObjectProvider(Provider), ApplicationContext를 사용해서 지연(LAZY) 조회
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class CallServiceV2 {

    // private final ApplicationContext applicationContext;
    private final ObjectProvider<CallServiceV2> callServiceProvider;

    public void external() {
        log.info("call external");
    // CallServiceV2 callServiceV2 = applicationContext.getBean(CallServiceV2.class); // getBean 호출 시점에 스프링 컨테이너에서 빈을 조회
        CallServiceV2 callServiceV2 = callServiceProvider.getObject(); // getObject 호출 시점에 스프링 컨테이너에서 빈을 조회
        callServiceV2.internal(); //외부 메서드 호출
    }

    public void internal() {
        log.info("call internal");
    }
}