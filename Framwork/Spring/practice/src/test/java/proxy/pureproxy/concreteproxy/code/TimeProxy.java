package proxy.pureproxy.concreteproxy.code;

import lombok.extern.slf4j.Slf4j;

/**
 * 프록시 패턴 - 구체 클래스 기반
 * ConcreteLogic 객체를 상속받아 기능을 재정의 하고 그 안에서 실제 객체를 호출하는 객체
 */
@Slf4j
public class TimeProxy extends ConcreteLogic{

    private ConcreteLogic realLogic;

    public TimeProxy(ConcreteLogic realLogic) {
        this.realLogic = realLogic;
    }

    @Override
    public String operation() {
        log.info("TimeDecorator 실행");

        long startTime = System.currentTimeMillis();

        String result = realLogic.operation();

        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;

        log.info("TimeDecorator 종료 resultTime={}", resultTime);
        return result;
    }
}
