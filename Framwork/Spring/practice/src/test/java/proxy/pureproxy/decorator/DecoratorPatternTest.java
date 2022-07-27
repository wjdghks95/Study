package proxy.pureproxy.decorator;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import proxy.pureproxy.decorator.code.*;

@Slf4j
public class DecoratorPatternTest {

    @Test
    void noDecorator() {
        Component realComponent = new RealComponent();
        DecoratorPatternClient client = new DecoratorPatternClient(realComponent);
        client.execute();
    }

    @Test
    void decorator1() {
        Component realComponent = new RealComponent(); // 실제 객체
        Component messageDecorator = new MessageDecorator(realComponent); // 프록시(실제 객체 참조)
        DecoratorPatternClient client = new DecoratorPatternClient(messageDecorator); // 클라이언트(프록시 참조)
        client.execute();
    }

    @Test
    void decorator2() {
        Component realComponent = new RealComponent(); // 실제 객체
        Component messageDecorator = new MessageDecorator(realComponent); // 프록시(실제 객체 참조)
        Component timeDecorator = new TimeDecorator(messageDecorator); // 프록시(프록시 참조)
        DecoratorPatternClient client = new DecoratorPatternClient(timeDecorator); // 클라이언트(프록시 참조)
        client.execute();
    }
}
