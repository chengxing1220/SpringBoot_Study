package com.tellhow.review.spring_annotation.attribute.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

/**
 * 祸殃
 *
 * 给属性赋值
 *    @Value注解可以给属性赋值，给属性赋值的
 *      1、value=字符串，直接将字符串赋值给属性
 *      2、value="#{}",大括号里可以写表达式
 *      3、value="${}",大括号里可以取环境变量中的值
 *      要想向将配置文件中的值赋给属性，我们要先将配置文件的值加到环境变量中。这里需要用到@PropertySource注解，它的value属性指定配置文件的类路径例如:@PropertySource(value ={"classpath:/myconfig.properties"})，@PropertySource注解一般加在配置类类名上
 */
public class Disaster {
    @Value("祸殃")
    private String name;
    @Value("#{1+89}")
    private int age;
    @Value("${disaster.state}")
    private String state;//姿态

    @Override
    public String toString() {
        return "Disaster{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", state='" + state + '\'' +
                '}';
    }
}
