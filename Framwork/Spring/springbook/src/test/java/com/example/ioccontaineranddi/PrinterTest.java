package com.example.ioccontaineranddi;

import org.junit.Test;
import org.springframework.beans.factory.config.RuntimeBeanReference;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.context.support.StaticApplicationContext;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class PrinterTest {

    @Test
    public void beanDefinitionTest() {
        StaticApplicationContext ac = new StaticApplicationContext(); // IoC 컨테이너 생성. 생성과 동시에 컨테이너로 동작한다.
        ac.registerSingleton("hello1", Hello.class); // Hello 클래스를 hello1이라는 이름의 싱글톤 빈으로 컨테이너에 등록한다.

        // IoC 컨테이너가 등록한 빈을 생성했는지 확인하기 위해 빈을 요청하고 Null이 아닌지 확인한다.
        Hello hello1 = ac.getBean("hello1", Hello.class);
        assertThat(hello1, is(notNullValue()));

        RootBeanDefinition helloDef = new RootBeanDefinition(Hello.class); // 빈 메타정보를 담은 오브젝트를 만든다. 빈 클래스는 Hello로 지정한다. <bean class="com.example...Hello" />에 해당하는 메타정보다.
        helloDef.getPropertyValues().addPropertyValue("name", "Spring"); // 빈의 name 프로퍼티에 들어갈 값을 지정한다. <property name="name" value="Spring" />에 해당한다.
        ac.registerBeanDefinition("hello2", helloDef); // 앞에서 생성한 빈 메타정보를 hello2라는 이름을 가진 빈으로 등록한다. <bean id="hello2" .../>에 해당한다.

        // BeanDefinition으로 등록된 빈이 컨테이너에 의해 만들어지고 프로퍼티 설정이 있는지 확인한다.
        Hello hello2 = ac.getBean("hello2", Hello.class);
        assertThat(hello2.sayHello(), is("Hello Spring"));

        assertThat(hello1, is(not(hello2))); // 처음 등록한 빈과 두 번째 등록한 빈이 모두 동일한 Hello 클래스지만 별개의 오브젝트로 생성됐다.

        assertThat(ac.getBeanFactory().getBeanDefinitionCount(), is(2));

    }

    @Test
    public void registerBeanWithDependency() {
        StaticApplicationContext ac = new StaticApplicationContext();
        ac.registerBeanDefinition("printer", new RootBeanDefinition(StringPrinter.class)); // StringPrinter 클래스 타입이며 printer라는 이름을 가진 빈을 등록한다.

        RootBeanDefinition helloDef = new RootBeanDefinition(Hello.class);
        helloDef.getPropertyValues().addPropertyValue("name", "Spring"); // 단순 값을 갖는 프로퍼티 등록
        helloDef.getPropertyValues().addPropertyValue("printer", new RuntimeBeanReference("printer")); // 아이디가 printer인 빈에 대한 래퍼런스를 프로퍼티로 등록

        ac.registerBeanDefinition("hello", helloDef);

        Hello hello = ac.getBean("hello", Hello.class);
        hello.print();

        // Hello 클래스의 print() 메소드는 DI 된 Printer 타입의 오브젝트에게 요청해서 인사말을 출력한다.
        // 이 결과를 스트링으로 저장해두는 printer 빈을 통해 확인한다.
        assertThat(ac.getBean("printer").toString(), is("Hello Spring"));
    }

    @Test
    public void genericApplicationContext() {
        GenericApplicationContext ac = new GenericApplicationContext();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(ac);
        reader.loadBeanDefinitions("/genericApplicationContext.xml"); // XmlBeanDefinitionReader는 기본적으로 클래스패스로 정의된 리소스로부터 파일을 읽는다.

        ac.refresh(); // 모든 메타정보가 등록이 완료됐으니 애플리케이션 컨테이너를 초기화하라는 명령이다.

//        GenericXmlApplicationContext ac = new GenericXmlApplicationContext("/genericApplicationContext.xml"); // 애플리케이션 컨텍스트 생성과 동시에 XML 파일을 읽어오고 초기화까지 수행한다.

        Hello hello = ac.getBean("hello", Hello.class);
        hello.print();

        assertThat(ac.getBean("printer").toString(), is("Hello Spring"));
    }

    @Test
    public void contextHierarchy() {
        // 부모 컨텍스트 생성
        GenericXmlApplicationContext parent = new GenericXmlApplicationContext("/parentContext.xml");

        // 자식 컨텍스트 생성
        GenericApplicationContext child = new GenericApplicationContext(parent);
        // 설정 메타정보 읽고 초기화
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(child);
        reader.loadBeanDefinitions("/childContext.xml");
        child.refresh(); // 리더를 사용해서 설정을 읽은 경우 반드시 refresh()를 통해 초기화해야 한다.

        Printer printer = child.getBean("printer", Printer.class);
        assertThat(printer, is(notNullValue()));

        Hello hello = child.getBean("hello", Hello.class);
        assertThat(hello, is(notNullValue()));

        hello.print();
        assertThat(printer.toString(), is("Hello Child")); // getBean()으로 가져온 hello 빈은 자식 컨텍스트에 존재하는 것임을 확인할 수 있다.
    }
}