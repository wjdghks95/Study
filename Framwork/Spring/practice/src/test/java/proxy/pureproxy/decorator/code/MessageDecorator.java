package proxy.pureproxy.decorator.code;

import lombok.extern.slf4j.Slf4j;

/**
 * 데코레이터 패턴
 * Component 의 기능을 구현하고 그 안에서 실제 객체 또는 프록시(데코레이터)를 호출하는 프록시
 */
@Slf4j
public class MessageDecorator implements Component{

    private Component component;

    public MessageDecorator(Component component) {
        this.component = component;
    }

    @Override
    public String operation() {
        log.info("MessageDecorator 실행");

        String result = component.operation();
        String decoResult = "*****" + result + "*****";

        log.info("MessageDecorator 꾸미기 적용 전={}, 적용 후={}", result, decoResult);
        return decoResult;
    }
}
