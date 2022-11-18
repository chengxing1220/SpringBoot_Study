package com.tellhow.review.spring_annotation.di.config;

import com.tellhow.review.spring_annotation.di.BuiltInComponents;
import com.tellhow.review.spring_annotation.di.pojo.PersonPojo;
import com.tellhow.review.spring_annotation.di.pojo.SkillPojo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.*;

/**
 * 依赖注入测试
 * 使用 @Configuration+@Bean向容器中注入组件时，被@Bean修饰的方法的参数从容器中取
 * 环境激活注解 @Profile
 * 被@Profile修饰的组件，会在指定的环境被激活。默认组件的环境是default，它们会在任何环境都会被激活
 * 激活环境的方式
 * 1、在环境变量中添加spring.profiles.active=dev
 * 2、代码激活
 * AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();//创建Ioc容器
 * context.getEnvironment().setActiveProfiles("test");//激活test环境
 * context.register(DIConfig.class);//注册配置类
 * context.refresh();
 */
@Configuration
@ComponentScan(value = {"com.tellhow.review.spring_annotation.di"})
@Slf4j
public class DIConfig {
    @Bean(value = "nanminglihuo")//南明离火
    public SkillPojo skillPojo2() {
        SkillPojo skillPojo = new SkillPojo();
        skillPojo.setName("暗日");
        skillPojo.setType("技能类");
        return skillPojo;
    }

    @Bean("zhuque")
    public PersonPojo personPojo2(SkillPojo martial) {
        PersonPojo personPojo = new PersonPojo();//白虎
        personPojo.setName("陆言");
        personPojo.setTitle("朱雀");
        return personPojo;
    }


    @Bean(value = "martial")//百兵演武
    @Primary //这个注解，会让组件优先被注入
    @Profile("dev")
    public SkillPojo skillPojo() {
        SkillPojo skillPojo = new SkillPojo();
        skillPojo.setName("百兵演武");
        skillPojo.setType("武器类");
        return skillPojo;
    }

    @Bean("baihui")
    @Primary//方法中的参数的值从容器中获取
    @Profile("dev")
    public PersonPojo personPojo(SkillPojo martial) {
        PersonPojo personPojo = new PersonPojo();//白虎
        personPojo.setName("樊奇");
        personPojo.setTitle("白虎");
        return personPojo;
    }


    //测试自定义组件及弟三方组件注入
    public static void testMyComponent() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.getEnvironment().setActiveProfiles("test");//激活test环境
        context.register(DIConfig.class);
        context.refresh();
        String[] names = context.getBeanNamesForType(PersonPojo.class);
        for (String name : names) {
            log.info(name);
        }
    }

    //注入Spring内置组件
    public static void testBuiltInComponent() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DIConfig.class);
        BuiltInComponents bean = context.getBean(BuiltInComponents.class);
        log.info("这个电脑操作系统是:"+bean.getOsName());
        log.info("BuiltInComponents的ApplicationContext()是不是Spring容器：" + (bean.getApplicationContext() == context));
    }

    public static void main(String[] args) {
        //testMyComponent();
        testBuiltInComponent();
    }
}
