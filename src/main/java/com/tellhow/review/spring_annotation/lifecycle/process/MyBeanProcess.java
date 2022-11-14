package com.tellhow.review.spring_annotation.lifecycle.process;

import com.tellhow.review.spring_annotation.lifecycle.pojo.BlackDragon;
import com.tellhow.review.spring_annotation.lifecycle.pojo.NaturalDisasterPojo;
import com.tellhow.review.spring_annotation.lifecycle.pojo.WhiteTiger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Slf4j
public class MyBeanProcess implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        log.info("初始化前");
        if (bean instanceof BlackDragon) {
            ((BlackDragon) bean).setName("宁仲");
        } else if (bean instanceof WhiteTiger) {
            ((WhiteTiger) bean).setName("樊奇");
        } else if (bean instanceof NaturalDisasterPojo) {
            ((NaturalDisasterPojo) bean).setName("李存孝");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        log.info("初始化后");
        return bean;
    }

    public MyBeanProcess() {
        log.info("MyBeanProcess利用无参构造创建对象");
    }

    @PostConstruct
    public void init(){
        log.info("MyBeanProcess初始化");
    }
}
