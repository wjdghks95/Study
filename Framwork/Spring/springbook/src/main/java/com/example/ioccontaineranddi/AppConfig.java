package com.example.ioccontaineranddi;

import org.springframework.context.annotation.*;

//@ComponentScan("com.example.ioccontaineranddi")
//@ComponentScan(basePackageClasses = ServiceMaker.class) // 마커 인터페이스를 이용한 빈 스캔 패키지 지정
//@ComponentScan(basePackages = "com.example.ioccontaineranddi", excludeFilters = @ComponentScan.Filter(Configuration.class)) // @Configuration 클래스를 제외한 설정
//@ComponentScan(basePackages = "com.example.ioccontaineranddi", excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = AppConfig.class)) // 타입을 이용한 제외 대상 지정
//@Import(DataConfig.class) // 다른 @Configuration 클래스를 빈 메타정보에 추가할 때 사용
//@ImportResource("/security.xml") // XML 파일의 빈 설정을 가져온다.
@Configuration
public class AppConfig {

    @Configuration
    @Profile("spring-test")
    public static class SpringTestConfig {}

    @Configuration
    @Profile("dev")
    public static class DevConfig {}

    @Configuration
    @Profile("production")
    public static class ProductionConfig {}
}



