package io.security.corespringsecurity2.security.factory;

import io.security.corespringsecurity2.service.SecurityResourceService;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.security.access.ConfigAttribute;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * DB에서 권한설정을 가져와서 resourcesMap에 등록
 */
public class MethodResourcesMapFactoryBean implements FactoryBean<LinkedHashMap<String, List<ConfigAttribute>>> {
    private SecurityResourceService securityResourceService;

    private LinkedHashMap<String, List<ConfigAttribute>> resourcesMap;

    public void setResourcesMap(LinkedHashMap<String, List<ConfigAttribute>> resourcesMap) {
        this.resourcesMap = resourcesMap;
    }

    public void setSecurityResourceService(SecurityResourceService securityResourceService) {
        this.securityResourceService = securityResourceService;
    }

    @Override
    public LinkedHashMap<String, List<ConfigAttribute>> getObject() {
        if(resourcesMap == null){
            init();
        }
        return resourcesMap;
    }
    private void init(){
        resourcesMap = securityResourceService.getMethodResourceList();
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
