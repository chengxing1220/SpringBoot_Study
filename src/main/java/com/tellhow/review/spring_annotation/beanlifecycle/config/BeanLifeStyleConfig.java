package com.tellhow.review.spring_annotation.beanlifecycle.config;

//import com.tellhow.review.spring_annotation.beanlifecycle.pojo.SectPojo;

import com.tellhow.review.spring_annotation.beanlifecycle.pojo.TaiQingSect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author wujianghao  bean的生命周期     创建对象-->初始化-->销毁对象
 * @date 2022年11月08日 16:16
 */
@Configuration
@ComponentScan(value = {"com.tellhow.review.spring_annotation.beanlifecycle"})
public class BeanLifeStyleConfig {
    @Bean(initMethod = "init", destroyMethod = "destory")
    public TaiQingSect taiQingSect() {
        TaiQingSect sect = new TaiQingSect();
        return sect;
    }
}
