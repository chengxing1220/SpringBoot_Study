package com.tellhow.review.spring_annotation.lifecycle.pojo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * 白虎
 */
@Component
@Slf4j
public class WhiteTiger {

    private String name;

    @PostConstruct
    public void init() {
        log.info(name+"努力修习，获得白虎称号");
    }

    @PreDestroy
    public void destory() {
        log.info(name+"为国捐躯");
    }

    public WhiteTiger() {
        log.info("白虎坑位留出");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
