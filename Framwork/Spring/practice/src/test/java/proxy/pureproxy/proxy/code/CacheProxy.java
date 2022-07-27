package proxy.pureproxy.proxy.code;

import lombok.extern.slf4j.Slf4j;

/**
 * 프록시 패턴
 * Subject 의 기능을 구현하고 그 안에서 실제 객체를 호출하는 프록시
 */
@Slf4j
public class CacheProxy implements Subject{

    private Subject target;

    private String cacheValue;

    public CacheProxy(Subject target) {
        this.target = target;
    }

    @Override
    public String operation() {
        log.info("프록시 호출");
        if (cacheValue == null) {
            cacheValue = target.operation();
        }
        return cacheValue;
    }
}
