package io.security.corespringsecurity2.security.configs;

import io.security.corespringsecurity2.security.factory.MethodResourcesMapFactoryBean;
import io.security.corespringsecurity2.service.SecurityResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.method.MapBasedMethodSecurityMetadataSource;
import org.springframework.security.access.method.MethodSecurityMetadataSource;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;

/**
 * AOP 기반 Method 방식 - Map 기반 DB 연동
 */
@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true) // 어노테이션 권한 설정 활성화
public class MethodSecurityConfig extends GlobalMethodSecurityConfiguration{

    @Autowired
    private SecurityResourceService securityResourceService;

    /**
     * customMethodSecurityMetadataSource를 오버라이딩 해서 Map 기반으로 메소드 인가 처리를 할 수 있는 클래스를 생성해서 리턴
     */
    @Override
    protected MethodSecurityMetadataSource customMethodSecurityMetadataSource() {
        return mapBasedMethodSecurityMetadataSource();
    }

    @Bean
    public MapBasedMethodSecurityMetadataSource mapBasedMethodSecurityMetadataSource() {
        return new MapBasedMethodSecurityMetadataSource(methodResourcesMapFactoryBean().getObject());
    }

    @Bean
    public MethodResourcesMapFactoryBean methodResourcesMapFactoryBean() {
        MethodResourcesMapFactoryBean methodResourcesMapFactoryBean = new MethodResourcesMapFactoryBean();
        methodResourcesMapFactoryBean.setSecurityResourceService(securityResourceService);
        return methodResourcesMapFactoryBean;
    }
}