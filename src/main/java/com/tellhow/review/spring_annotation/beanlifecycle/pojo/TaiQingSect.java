package com.tellhow.review.spring_annotation.beanlifecycle.pojo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author wujianghao
 * @date 2022年11月09日 8:54
 * 太清道
 */
@Slf4j
public class TaiQingSect implements Sect{
    @Autowired
    LiuheSect liuheSect;

    public void init() {
        log.info("招纳太清道弟子");
    }
    public void destory() {
        log.info("太清道被灭");
    }

    public TaiQingSect() {
        log.info("创建太清道");
    }
}
