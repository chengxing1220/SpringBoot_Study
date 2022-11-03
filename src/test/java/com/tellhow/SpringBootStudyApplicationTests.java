package com.tellhow;

import com.tellhow.review.spring_annotation.beanaddcontainer.config.MyConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootTest
@Slf4j
class SpringBootStudyApplicationTests {

    @Test
        //测试xml配置源数据
    void contextLoads() {
        //BeanFactory 接口提供了一种能够管理任何类型对象的高级配置机制。ApplicationContext 是 BeanFactory 的一个子接口
        //ApplicationContext 接口代表 Spring IoC 容器，负责实例化、配置和组装 bean
        ApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("spring/beans.xml");
        log.info("----------------------------------------applicationContext容器中有以下组件-------------------------------------");
        for (String beanDefinitionName : classPathXmlApplicationContext.getBeanDefinitionNames()) {
            log.info(beanDefinitionName);
        }
    }


    @Test
    //注解配置元数据
    void testAnnotationContextLoad() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyConfig.class);
        log.info("-----------------------------------------applicationContext容器中有以下组件------------------------------------");
        for (String beanDefinitionName : applicationContext.getBeanDefinitionNames()) {
            log.info(beanDefinitionName);
        }
        Object bean = applicationContext.getBean("myFactoryBean");
        Object bean2 = applicationContext.getBean("myFactoryBean");
        log.info((bean==bean2)+"");
    }


}
