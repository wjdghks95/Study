package com.example.ioccontaineranddi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Hello {

//    @Value("#{systemProperties['os.name']}") // 외부의 리소스나 환경 정보에 담긴 값을 사용하도록 지정.
//    @Value("${db.username}") // 프로퍼티 파일에서 값을 사용하도록 지정
    private String name;
//            = "Everyone"; // 디폴트 값. 초기화를 해뒀기 때문에 name 프로퍼티를 설정하지 않아도 사용할 수 있다.
//            @Value("Everyone") // @Value 애노테이션을 이용한 디폴트 값.

    // @Resource(name = "printer") // 참조할 빈의 이름을 지정한다. name 생략 가능. setter 생략 가능
    @Autowired(required = false)
    Printer printer;

    List<String> namesList;
    Set<String> namesSet;
    Map<String, Integer> ages;
    Properties settings;

    @Qualifier("mainDB")
//    @Database("main")
    DataSource dataSource;

    public Hello() {
    }

    public Hello(String name, Printer printer) {
        this.name = name;
        this.printer = printer;
    }

    @Autowired
    public void config(@Qualifier("mainDB") DataSource dataSource, Printer printer) {
        this.dataSource = dataSource;
        this.printer = printer;
    }

    public String sayHello() {
        return "Hello " + name; // 프로퍼티로 DI 받은 이름을 이용해 간단한 인사문구 만들기
    }

    public void print() {
        // DI에 의해 의존 오브젝트로 제공받은 Printer 타입의 오브젝트에게 출력 작업을 위임한다.
        // 구체적으로 어떤 방식으로 출력하는지는 상관하지 않는다. 또한 어떤 방식으로 출력하도록 변경해도 Hello의 코드는 수정할 필요가 없다.
        this.printer.print(sayHello());
    }

    // 디폴트 값을 변경하고 싶을 땐 언제든지 프로퍼티의 값을 선언해서 바꿀 수 있다.
    public void setName(String name) {
        this.name = name; // 인사문구에 쓸 이름을 스트링 값으로 DI 받을 수 있다.
    }

//    @Resource(name = "printer")
//    @Autowired
    public void setPrinter(Printer printer) {
        this.printer = printer; // 출력을 위해 사용할 Printer 인터페이스를 구현한 오브젝트를 DI 받는다.
    }

    public void setNamesList(List<String> namesList) {
        this.namesList = namesList;
    }

    public void setNamesSet(Set<String> namesSet) {
        this.namesSet = namesSet;
    }

    public void setAges(Map<String, Integer> ages) {
        this.ages = ages;
    }

    public void setSettings(Properties settings) {
        this.settings = settings;
    }
}
