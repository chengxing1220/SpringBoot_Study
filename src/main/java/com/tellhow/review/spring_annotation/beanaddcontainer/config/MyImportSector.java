package com.tellhow.review.spring_annotation.beanaddcontainer.config;

import com.tellhow.review.common.pojo.PersonPojo;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportSector implements ImportSelector {
    //根据导入的@Configuration类的AnnotationMetadata选择并返回应该导入的类的名称。
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        String className = PersonPojo.class.getName();
        return new String[]{className};
    }
}
