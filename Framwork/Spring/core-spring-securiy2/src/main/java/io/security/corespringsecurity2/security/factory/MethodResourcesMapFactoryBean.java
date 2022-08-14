package io.security.corespringsecurity2.security.factory;

import io.security.corespringsecurity2.service.SecurityResourceService;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.security.access.ConfigAttribute;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * DB에서 권한 정보를 가져와서 resourcesMap에 등록
 */
public class MethodResourcesMapFactoryBean implements FactoryBean<LinkedHashMap<String, List<ConfigAttribute>>> {
    private SecurityResourceService securityResourceService;
    private String resourceType;

    private LinkedHashMap<String, List<ConfigAttribute>> resourcesMap;

    public void setResourcesMap(LinkedHashMap<String, List<ConfigAttribute>> resourcesMap) {
        this.resourcesMap = resourcesMap;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public void setSecurityResourceService(SecurityResourceService securityResourceService) {
        this.securityResourceService = securityResourceService;
    }

    @Override
    public LinkedHashMap<String, List<ConfigAttribute>> getObject() {
        if (resourcesMap == null) {
            init();
        }
        return resourcesMap;
    }

    public void init(){
        if("method".equals(resourceType)){
            resourcesMap = securityResourceService.getMethodResourceList();
        } else if("pointcut".equals(resourceType)){
            resourcesMap = securityResourceService.getPointcutResourceList();
        }
    }

    @Override
    public Class<?> getObjectType() {
        return LinkedHashMap.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
