package com.tellhow.review.common.factory;

import com.tellhow.review.common.pojo.WorldPojo;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.ResolvableType;
import org.springframework.stereotype.Component;

public class MyFactoryBean implements FactoryBean {

    @Override
    public Object getObject() throws Exception {
        WorldPojo worldPojo = new WorldPojo();
        worldPojo.setName("斗罗大陆");
        worldPojo.setWId("10086");
        return worldPojo;
    }

    @Override
    public Class<?> getObjectType() {
        return WorldPojo.class;
    }
}
