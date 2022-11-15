package com.tellhow.review.spring_annotation.attribute.config;

import com.tellhow.review.spring_annotation.attribute.pojo.Disaster;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 给属性赋值
 */
@Configuration
@Slf4j
@PropertySource(value ={"classpath:/myconfig.properties"})//会将配置文件的值加到环境变量中
public class AttributeAssignmentConfig {

    @Bean
    public Disaster disaster(){
        return new Disaster();
    }
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext= new AnnotationConfigApplicationContext(AttributeAssignmentConfig.class);
        String property = applicationContext.getEnvironment().getProperty("os.name");
        log.info(property);
        Disaster bean = applicationContext.getBean(Disaster.class);
        log.info(bean+"");
    }
}
