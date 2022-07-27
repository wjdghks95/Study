package proxy.pureproxy.proxy;

import org.junit.jupiter.api.Test;
import proxy.pureproxy.proxy.code.CacheProxy;
import proxy.pureproxy.proxy.code.ProxyPatternClient;
import proxy.pureproxy.proxy.code.RealSubject;
import proxy.pureproxy.proxy.code.Subject;

public class ProxyPatternTest {

    @Test
    void noProxyTest() {
        RealSubject realSubject = new RealSubject();
        ProxyPatternClient client = new ProxyPatternClient(realSubject);
        client.execute();
        client.execute();
        client.execute();
    }

    @Test
    void cacheProxyTest() {
        Subject realSubject = new RealSubject(); // 실제 객체
        Subject cacheProxy = new CacheProxy(realSubject); // 프록시(실제 객체 참조)
        ProxyPatternClient client = new ProxyPatternClient(cacheProxy); // 클라이언트(프록시 참조)
        client.execute();
        client.execute();
        client.execute();
    }
}
