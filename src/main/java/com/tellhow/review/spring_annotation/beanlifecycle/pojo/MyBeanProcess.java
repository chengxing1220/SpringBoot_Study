package com.tellhow.review.spring_annotation.beanlifecycle.pojo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author wujianghao
 * @date 2022年11月09日 9:43
 */
@Component
@Slf4j
public class MyBeanProcess implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {//BeanPostProcessor在初始化之前，运用这个方法
        if (beanName.equals("liuheSect")) {
            log.info("执行MyBeanProcess的postProcessBeforeInitialization方法");
        }
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        log.info("执行MyBeanProcess的postProcessAfterInitialization方法");
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
