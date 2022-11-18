package com.tellhow.review.spring_annotation.di;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * 向javaBean注入Spring内置组件.
 *    1、操作：Spring 提供了各种各样的xxxAware接口。只要实现了这些接口，就可以获取到相应Spring的内置组件，例如Spring的环境和容器
 *    下面以ApplicationContextAware和EnvironmentAware为例.
 *    2、原理：将Spring内置组件注入到javabean的属性中。它的底层原理是对应的EnvironmentPostProcessor接口
 *
 *
 *
 *
 * @author wujianghao
 * @date 2022年11月18日 15:42
 */
@Component
public class BuiltInComponents implements ApplicationContextAware, EnvironmentAware {
    ApplicationContext applicationContext;
    Environment environment;
    private String osName;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public Environment getEnvironment() {
        return environment;
    }

    public String getOsName() {
        return osName;
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
        this.osName = environment.getProperty("os.name");
    }
}
