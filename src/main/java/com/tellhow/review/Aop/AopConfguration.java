package com.tellhow.review.Aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Aop原理解析
 * 基本思路：Aop的底层原理是动态代理
 * @EnableAspectJAutoProxy开启切面动态代理，我们来看是怎么开启切面动态代理的
 * 1、它用@import向容器导入了一个类@Import(AspectJAutoProxyRegistrar.class)
 * 2、AspectJAutoProxyRegistrar implements ImportBeanDefinitionRegistrar，我们之前了解过@import3种向Spring容器中添加组件的方法。这里使用的是ImportBeanDefinitionRegistrar的方式详细见向@import的使用方式
 *
 *
 */
@EnableAspectJAutoProxy//@EnableAspectJAutoProxy开启切面代理功能，切面的底层就是代理
@Configuration
@ComponentScan(value = "com.tellhow.review.Aop")
public class AopConfguration {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopConfguration.class);
        Function bean = context.getBean(Function.class);
        bean.GhostInfestation("陈兴","除掉伥鬼");
        System.out.println(bean);
    }
}
