package hello.springcore.scope;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Prototype bean
 * 스프링 컨테이너에서 빈을 조회할 때 빈이 생성되고, 초기화 메서드도 실행
 * 다른 스프링 빈이 생성
 * 종료 메서드 호출 X
 */
public class PrototypeTest {

    @Test
    public void prototypeBeanFind() {

        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);
        PrototypeBean prototypeBean1 = ac.getBean(PrototypeBean.class);
        PrototypeBean prototypeBean2 = ac.getBean(PrototypeBean.class);
        System.out.println("PrototypeBean1 = " + prototypeBean1);
        System.out.println("PrototypeBean2 = " + prototypeBean2);

        assertThat(prototypeBean1).isSameAs(prototypeBean2);

        ac.close(); // 종료
    }

    @Scope("prototype")
    static class PrototypeBean {

        @PostConstruct
        public void init() {
            System.out.println("PrototypeBean.init");
        }

        @PreDestroy
        public void destroy() {
            System.out.println("PrototypeBean.destroy");
        }
    }
}
