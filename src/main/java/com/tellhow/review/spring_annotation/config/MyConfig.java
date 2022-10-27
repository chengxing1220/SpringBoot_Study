package com.tellhow.review.spring_annotation.config;

import com.tellhow.review.spring_xml.pojo.AvenueBranchPojo;
import com.tellhow.review.spring_xml.pojo.WorldPojo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

import java.util.ArrayList;

/**
 * @author wujianghao
 * @date 2022年10月27日 16:25
 */

/**
 * proxyBeanMethods属性是用来设置MyConfig配置类是否被代理。true的话通过MyConfig实例.方法获取对象时(非从容器中取)，每次取出来的都是同一个
 */
@Configuration(proxyBeanMethods = true)
@Slf4j
@ComponentScans(value = {@ComponentScan(basePackages = "com.tellhow")})//包扫描
public class MyConfig {
    @Bean
    public  WorldPojo worldPojo() {
        WorldPojo worldPojo = new WorldPojo();
        worldPojo.setName("斗气大陆");
        ArrayList<AvenueBranchPojo> avenueBranchPojos = new ArrayList<>();
        avenueBranchPojos.add(new AvenueBranchPojo("萧族"));
        worldPojo.setAvenueBranch(avenueBranchPojos);
        return worldPojo;
    }

}
