package com.tellhow;

import com.tellhow.review.common.factory.MyFactoryBean;
import com.tellhow.review.spring_annotation.beanaddcontainer.config.MyConfig;
import com.tellhow.review.spring_annotation.lifecycle.MainConfigLifeCycle;
import com.tellhow.review.spring_annotation.lifecycle.pojo.NaturalDisasterPojo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

   /* @Autowired
    @Qualifier("myFactoryBean")
    Object factoryBean2;*/


    @Test
        //注解配置元数据
    void testAnnotationContextLoad() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyConfig.class);
        log.info("-----------------------------------------applicationContext容器中有以下组件------------------------------------");
        for (String beanDefinitionName : applicationContext.getBeanDefinitionNames()) {
            log.info(beanDefinitionName);
        }
        Object bean = applicationContext.getBean("myFactoryBean");
        Object factoryBean = applicationContext.getBean(FactoryBean.class);
        Object bean2 = applicationContext.getBean("myFactoryBean");
        System.out.println(bean2);
        //System.out.println(factoryBean2);
       // log.info((factoryBean2 == bean2) + "");
    }


    @Test
    void testLifeCycle(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigLifeCycle.class);
        applicationContext.getBean(NaturalDisasterPojo.class);
      //  applicationContext.close();
    }

}
