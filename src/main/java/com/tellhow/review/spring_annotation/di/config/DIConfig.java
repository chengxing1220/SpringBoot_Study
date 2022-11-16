package com.tellhow.review.spring_annotation.di.config;

import com.tellhow.review.spring_annotation.di.controller.DynastyController;
import com.tellhow.review.spring_annotation.di.dao.DynastyDao;
import com.tellhow.review.spring_annotation.di.service.DynastyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.*;

import java.util.Map;

@Configuration
@ComponentScan(value = {"com.tellhow.review.spring_annotation.di"})
@Slf4j
public class DIConfig {


    @Bean
    @Primary
    public DynastyService dynastyService3() {
        DynastyService dynastyService = new DynastyService();
        dynastyService.setName("张三");
        return dynastyService;
    }


    /**
     * 组件注入之方法注入
     *    1、被@Bean修饰的方法，方法中的参数的值是从容器中取的
     *
     */
    @Bean
    public DynastyService dynastyService2(DynastyDao dao) {
        DynastyService dynastyService = new DynastyService();
        dynastyService.setDynastyDao(dao);
        return dynastyService;
    }


    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DIConfig.class);
        DynastyController bean = context.getBean(DynastyController.class);
        log.info(bean.getDynastyService().getName() + "");
    }
}
