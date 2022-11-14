package com.tellhow.review.spring_annotation.lifecycle;

import com.tellhow.review.spring_annotation.lifecycle.pojo.NaturalDisasterPojo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 一、bean的生命周期：
 *   bean创建---->初始化---->bean的销毁(单例bean会在容器关闭时销毁)
 * 二、指定bean的初始化和销毁方法的方式：
 *    1、使用@bean的initMethod属性和destroyMethod分别指定初始化和销毁方法
 *    2、实现InitializingBean并重写afterPropertiesSet()方法【此方法就是初始化方法】, 实现DisposableBean接口并重写destroy()方法【此方法即销毁方法】
 *    3、在方法上加 @PostConstruct注解，指定该方法为初始化方法。在方法上加@PreDestroy注解，指定该方法为销毁方法
 * 三、BeanPostProcessor。指定在bean初始化前和初始化后的调用
 *
 * AbstractAutowireCapableBeanFactory类有以下：
 *    populateBean(beanName, mbd, instanceWrapper);                  给bean的属性赋值
 * 	  exposedObject = initializeBean(beanName, exposedObject, mbd);  初始化
 *
 *    protected Object initializeBean(String beanName, Object bean, @Nullable RootBeanDefinition mbd){
 *            wrappedBean = applyBeanPostProcessorsBeforeInitialization(wrappedBean, beanName);//初始化之前调用
 * 			  invokeInitMethods(beanName, wrappedBean, mbd);//调用初始化方法
 * 			  wrappedBean = applyBeanPostProcessorsAfterInitialization(wrappedBean, beanName);//初始化之后调用
 *   }
 */
@Configuration
@ComponentScan(basePackages = {"com.tellhow.review.spring_annotation.lifecycle"})
@Slf4j
public class MainConfigLifeCycle {
    @Bean(value = "naturalDisasterPojo2",initMethod = "init",destroyMethod = "destory")
    public NaturalDisasterPojo naturalDisasterPojo(){
        return new NaturalDisasterPojo();
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(MainConfigLifeCycle.class);
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String beanName:beanDefinitionNames){
            log.info(beanName);
        }
      //  context.close();
    }
}
