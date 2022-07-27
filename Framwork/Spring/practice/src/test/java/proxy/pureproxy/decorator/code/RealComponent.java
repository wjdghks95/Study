package proxy.pureproxy.decorator.code;

import lombok.extern.slf4j.Slf4j;

/**
 * 데코레이터 패턴
 * Component 기능을 구현한 구현체
 */
@Slf4j
public class RealComponent implements Component{

    @Override
    public String operation() {
        log.info("RealComponent 실행");
        return "data";
    }
}
