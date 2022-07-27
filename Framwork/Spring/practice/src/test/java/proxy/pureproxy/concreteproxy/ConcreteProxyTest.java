package proxy.pureproxy.concreteproxy;

import org.junit.jupiter.api.Test;
import proxy.pureproxy.concreteproxy.code.ConcreteClient;
import proxy.pureproxy.concreteproxy.code.ConcreteLogic;
import proxy.pureproxy.concreteproxy.code.TimeProxy;

public class ConcreteProxyTest {

    @Test
    void noProxy() {
        ConcreteLogic concreteLogic = new ConcreteLogic();
        ConcreteClient client = new ConcreteClient(concreteLogic);
        client.execute();
    }

    @Test
    void addProxy() {
        ConcreteLogic concreteLogic = new ConcreteLogic(); // 실제 객체
        TimeProxy timeProxy = new TimeProxy(concreteLogic); // 프록시(실제 객체 참조)
        ConcreteClient client = new ConcreteClient(timeProxy); // 클라이언트(프록시 참조)
        client.execute();
    }
}
