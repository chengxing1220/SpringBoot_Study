package com.tellhow.review.spring_annotation.lifecycle.pojo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 青龙
 */
@Component
@Slf4j
public class BlackDragon implements InitializingBean, DisposableBean {
    @Value("楼")
    private String name;

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info(name + "获得青龙称号");
    }

    @Override
    public void destroy() throws Exception {
        log.info(name+"死去");
    }

    public BlackDragon() {
        log.info("青龙坑位留出");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
