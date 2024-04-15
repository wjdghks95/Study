package com.example.ioccontaineranddi;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ScopeTest {
    @Test
    public void singletonScope() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SingletonBean.class, SingletonClientBean.class);
        Set<SingletonBean> beans = new HashSet<>(); // Set은 중복을 허용하지 않으므로 같은 오브젝트는 여러 번 추가해도 한 개만 남는다.

        // DL에서 싱글톤 확인
        beans.add(ac.getBean(SingletonBean.class));
        beans.add(ac.getBean(SingletonBean.class));
        assertThat(beans.size(), is(1));

        // DL에서 싱글톤 확인
        beans.add(ac.getBean(SingletonClientBean.class).bean1);
        beans.add(ac.getBean(SingletonClientBean.class).bean2);
        assertThat(beans.size(), is(1));
    }

    static class SingletonBean {} // 싱글톤 스코프 빈. Scope 빈 메타정보의 디폴트 값은 "singleton"이기 때문에 별도의 스코프 설정은 필요 없다.
    static class SingletonClientBean {
        // 한 번 이상 DI가 일어날 수 있도록 두 개의 DI용 프로퍼티를 선언해뒀다.
        @Autowired SingletonBean bean1;
        @Autowired SingletonBean bean2;
    }

    @Test
    public void prototypeScope() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class, PrototypeClient.class);
        Set<PrototypeBean> beans = new HashSet<>(); // Set은 중복을 허용하지 않으므로 같은 오브젝트는 여러 번 추가해도 한 개만 남는다.

        // 프로토타입 빈은 DL 방식으로 컨테이너에 빈을 요청할 때마다 새로운 빈 오브젝트가 만들어지는 것을 확인한다.
        beans.add(ac.getBean(PrototypeBean.class));
        assertThat(beans.size(), is(1));
        beans.add(ac.getBean(PrototypeBean.class));
        assertThat(beans.size(), is(2));

        // 프로토타입 빈을 DI 할 때도 주입받는 프로퍼티마다 다른 오브젝트가 만들어지는 것을 확인한다.
        beans.add(ac.getBean(PrototypeClient.class).bean1);
        assertThat(beans.size(), is(3));
        beans.add(ac.getBean(PrototypeClient.class).bean2);
        assertThat(beans.size(), is(4));
    }

    @Scope("prototype") // 애노테이션을 이용해 프로토타입 빈으로 만들려면 @Scope의 기본 값을 prototype으로 지정한다.
    static class PrototypeBean {}
    static class PrototypeClient {
        @Autowired PrototypeBean bean1;
        @Autowired PrototypeBean bean2;
    }
}
