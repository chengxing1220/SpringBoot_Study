package com.tellhow.review.spring_annotation.beanaddcontainer.main;

import com.tellhow.review.common.pojo.AvenueBranchPojo;
import com.tellhow.review.common.pojo.WorldPojo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ComponentScan(value="com.tellhow.review.spring_annotation")
@Slf4j
public class SpringAnnotationApplication {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringAnnotationApplication.class);//Spring容器
        WorldPojo world = applicationContext.getBean(WorldPojo.class);
        List<AvenueBranchPojo> avenueBranch = world.getAvenueBranch();
        List<AvenueBranchPojo> avenueBranch2 = world.getAvenueBranch();
        System.out.println(avenueBranch2==avenueBranch);
    }
}
