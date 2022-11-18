package com.tellhow.review.spring_annotation.beanlifecycle.pojo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author wujianghao
 * 六合帮
 * @date 2022年11月09日 9:00
 */
@Slf4j
@Component
public class LiuheSect implements Sect {
    @PostConstruct
    public void init() {
        log.info("六合帮招弟子");
    }

    public LiuheSect() {
        log.info("创建六合帮");
    }

    @PreDestroy
    public void destroy() {
        log.info("六合帮被灭");
    }
}
