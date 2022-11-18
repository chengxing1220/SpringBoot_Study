package com.tellhow.review.spring_annotation.componenttocontainer.test;

import com.tellhow.review.spring_annotation.beanaddcontainer.config.MyConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

/**
 * @author wujianghao
 * @date 2022年10月31日 9:25
 * Spring通过注解的方式将组件加到容器的方式测试
 */
@Slf4j
@Configuration
public class SpringAnnotationAddComponent {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyConfig.class);
        for (String beanDefinitionName : applicationContext.getBeanDefinitionNames()) {
           log.info(beanDefinitionName);
        }
    }

}
