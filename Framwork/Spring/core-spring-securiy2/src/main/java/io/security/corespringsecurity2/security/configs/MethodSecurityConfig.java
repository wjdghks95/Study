package io.security.corespringsecurity2.security.configs;

import io.security.corespringsecurity2.security.enums.SecurtiyMethodType;
import io.security.corespringsecurity2.security.factory.MethodResourcesMapFactoryBean;
import io.security.corespringsecurity2.security.interceptor.CustomMethodSecurityInterceptor;
import io.security.corespringsecurity2.security.processor.ProtectPointcutPostProcessor;
import io.security.corespringsecurity2.service.SecurityResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.access.intercept.RunAsManager;
import org.springframework.security.access.method.MapBasedMethodSecurityMetadataSource;
import org.springframework.security.access.method.MethodSecurityMetadataSource;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;

import java.lang.annotation.Retention;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Map;

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
        methodResourcesMapFactoryBean.setResourceType(SecurtiyMethodType.METHOD.getValue());
        return methodResourcesMapFactoryBean;
    }

    @Bean
    public ProtectPointcutPostProcessor protectPointcutPostProcessor() {

        ProtectPointcutPostProcessor protectPointcutPostProcessor = new ProtectPointcutPostProcessor(mapBasedMethodSecurityMetadataSource());
        protectPointcutPostProcessor.setPointcutMap(pointcutResourcesMapFactoryBean().getObject());

        return protectPointcutPostProcessor;
    }

    @Bean
    public MethodResourcesMapFactoryBean pointcutResourcesMapFactoryBean(){

        MethodResourcesMapFactoryBean pointcutResourcesMapFactoryBean = new MethodResourcesMapFactoryBean();
        pointcutResourcesMapFactoryBean.setSecurityResourceService(securityResourceService);
        pointcutResourcesMapFactoryBean.setResourceType(SecurtiyMethodType.POINTCUT.getValue());
        return pointcutResourcesMapFactoryBean;

    }

    @Bean
    public CustomMethodSecurityInterceptor customMethodSecurityInterceptor(MapBasedMethodSecurityMetadataSource methodSecurityMetadataSource) {
        CustomMethodSecurityInterceptor customMethodSecurityInterceptor =  new CustomMethodSecurityInterceptor();
        customMethodSecurityInterceptor.setAccessDecisionManager(accessDecisionManager());
        customMethodSecurityInterceptor.setAfterInvocationManager(afterInvocationManager());
        customMethodSecurityInterceptor.setSecurityMetadataSource(methodSecurityMetadataSource);
        RunAsManager runAsManager = runAsManager();
        if (runAsManager != null) {
            customMethodSecurityInterceptor.setRunAsManager(runAsManager);
        }

        return customMethodSecurityInterceptor;
    }

//    @Bean
//    BeanPostProcessor protectPointcutPostProcessor() throws Exception{
//        Class<?> clazz = Class.forName("org.springframework.security.config.method.ProtectPointcutPostProcessor");
//        Constructor<?> declaredConstructor = clazz.getDeclaredConstructor(MapBasedMethodSecurityMetadataSource.class);
//        declaredConstructor.setAccessible(true);
//        Object instance = declaredConstructor.newInstance(mapBasedMethodSecurityMetadataSource());
//        Method setPointcutMap = instance.getClass().getMethod("setPointcutMap", Map.class);
//        setPointcutMap.setAccessible(true);
//        setPointcutMap.invoke(instance,pointcutResourcesMapFactoryBean().getObject());
//
//        return (BeanPostProcessor)instance;
//    }
}