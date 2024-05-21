package com.example.springbook2.etc;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class HelloSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        String mode = (String) annotationMetadata.getAnnotationAttributes(EnableHello.class.getName()).get("mode");
        if ("mode1".equals(mode)) {
            return new String[]{HelloConfig1.class.getName()};
        } else {
            return new String[]{HelloConfig2.class.getName()};
        }
    }
}
