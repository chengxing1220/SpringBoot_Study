package com.tellhow.review.spring_annotation.beanaddcontainer.config;

import com.tellhow.review.common.common.CommonController;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {


    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
       registry.registerBeanDefinition("commonController",new RootBeanDefinition(CommonController.class));
    }
}
